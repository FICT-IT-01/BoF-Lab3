package com.kpi.it01.team1.helpers;

import com.kpi.it01.team1.Constants;
import com.kpi.it01.team1.exceptions.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RequestHelper {
    private final HttpServletRequest request;

    public RequestHelper(HttpServletRequest request) {
        this.request = request;
    }

    public Cookie getCookieByName(String name) throws InvalidCookieException {
        Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals(name)).findFirst();
        return cookie.orElseThrow(() -> new InvalidCookieException("Cookie " + name + " isn`t exists", name));
    }

    public ArrayList<Integer> getParametersValueByNames(String... names) throws InvalidParameterException {
        ArrayList<Integer> values = new ArrayList<>();

        for (String name : names) {
            values.add(getParameterValueByName(name));
        }

        return values;
    }

    public Integer getParameterValueByName(String name) throws InvalidParameterException {
        try {
            return Integer.parseInt(request.getParameter(name));
        } catch (Exception e) {
            throw new InvalidParameterException("Parameter " + name + " doesn`t contains value", name, e);
        }
    }

    public Cookie getPreviousValuesCookie() {
        Cookie prevValuesCookie;

        try {
            prevValuesCookie = getCookieByName(Constants.PREVIOUS_VALUES_COOKIE_NAME);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();

            ArrayList<Integer> default_values = Constants.DEFAULT_VALUES;
            for (int i = 0; i < default_values.size(); i++) {
                Integer n = default_values.get(i);
                if (i == default_values.size() - 1) {
                    sb.append(n);
                    break;
                }
                sb.append(n).append("$");
            }

            prevValuesCookie = new Cookie(Constants.PREVIOUS_VALUES_COOKIE_NAME, sb.toString());
        }

        return prevValuesCookie;
    }
}
