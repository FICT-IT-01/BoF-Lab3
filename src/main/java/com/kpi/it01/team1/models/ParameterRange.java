package com.kpi.it01.team1.models;

public class ParameterRange {
    private final int minValue;
    private final int maxValue;
    private final int step;

    public ParameterRange(int minValue, int maxValue, int step) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getStep() {
        return step;
    }
}
