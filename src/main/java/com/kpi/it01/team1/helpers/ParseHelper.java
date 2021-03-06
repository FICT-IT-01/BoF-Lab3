package com.kpi.it01.team1.helpers;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseHelper {
    public ArrayList<Integer> getPreviousValuesFromCookieValue(String cookieContent) {
        return Stream.of(cookieContent.split("\\$"))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public String createPreviousValuesCookieValue(ArrayList<Integer> values) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.size(); i++) {
            Integer n = values.get(i);
            if (i == values.size() - 1) {
                sb.append(n);
                break;
            }
            sb.append(n).append("$");
        }

        return sb.toString();
    }
}
