package com.kpi.it01.team1.models;

public class ParameterRange {
    private final double minValue;
    private final double maxValue;
    private final double step;

    public ParameterRange(double minValue, double maxValue, double step) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.step = step;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getStep() {
        return step;
    }
}
