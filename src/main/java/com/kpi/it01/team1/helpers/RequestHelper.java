package com.kpi.it01.team1.helpers;

import com.kpi.it01.team1.exceptions.InvalidCookieException;
import com.kpi.it01.team1.exceptions.InvalidParameterException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class RequestHelper {
    private final HttpServletRequest request;

    public RequestHelper(HttpServletRequest request) {
        this.request = request;
    }

    public ArrayList<Double> getCookiesValueByCookiesNames(String... names) throws InvalidCookieException {
        ArrayList<Double> values = new ArrayList<>();

        for (String name : names) {
            values.add(getValueFromCookie(getCookieByName(name)));
        }

        return values;
    }
    
    public ArrayList<Cookie> getCookiesByNames(String... names) throws InvalidCookieException {
        ArrayList<Cookie> cookies = new ArrayList<>();

        for (String name : names) {
            cookies.add(getCookieByName(name));
        }

        return cookies;
    }

    public Cookie getCookieByName(String name) throws InvalidCookieException {
        Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals(name)).findFirst();
        return cookie.orElseThrow(() -> new InvalidCookieException("Cookie " + name + " isn`t exists", name));
    }

    public double getValueFromCookie(Cookie cookie) throws InvalidCookieException {
        try {
            return Double.parseDouble(cookie.getValue());
        }
        catch (Exception e) {
            throw new InvalidCookieException("Cookie " + cookie.getName() + " doesn`t contains value", cookie.getName(), e);
        }
    }

    public void setCookiesValues(ArrayList<Cookie> cookies, ArrayList<Double> values) {
        if (cookies.size() != values.size()) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }

        for (int i = 0; i < cookies.size(); i++) {
            cookies.get(i).setValue(Double.toString(values.get(i)));
        }
    }

    public ArrayList<Double> getParametersValueByNames(String... names) throws InvalidParameterException {
        ArrayList<Double> values = new ArrayList<>();

        for (String name : names) {
            values.add(getParameterValueByName(name));
        }

        return values;
    }

    public Double getParameterValueByName(String name) throws InvalidParameterException {
        try {
            return Double.parseDouble(request.getParameter(name));
        }
        catch (Exception e) {
            throw new InvalidParameterException("Parameter " + name + " doesn`t contains value", name, e);
        }
    }
}
