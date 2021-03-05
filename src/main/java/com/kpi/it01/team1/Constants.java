package com.kpi.it01.team1;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    public static final ArrayList<Integer> DEFAULT_VALUES = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1));
    public static final String[] REQUIRED_PARAMETERS = new String[]
            {"a-from", "a-to", "a-step", "b-from", "b-to", "b-step", "c-from", "c-to", "c-step", "d-from", "d-to", "d-step"};
    public static final String[] PARAMETERS_NAMES = new String[] {"a", "b", "c", "d"};

    public static final String PREVIOUS_VALUES_COOKIE_NAME = "prevValues";
    public static final String TASK_ID_PARAMETER = "taskid";

}
