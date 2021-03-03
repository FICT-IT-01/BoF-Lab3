package com.kpi.it01.team1.models;

import java.util.ArrayList;

public class InputRequestData {
    private final ParameterRange paramARange;
    private final ParameterRange paramBRange;
    private final ParameterRange paramCRange;
    private final ParameterRange paramDRange;

    public InputRequestData(ArrayList<Integer> numbers) {
        if (numbers.size() != 12) {
            throw new IllegalArgumentException("Array must contains 12 digits");
        }

        this.paramARange = new ParameterRange(numbers.get(0), numbers.get(1), numbers.get(2));
        this.paramBRange = new ParameterRange(numbers.get(3), numbers.get(4), numbers.get(5));
        this.paramCRange = new ParameterRange(numbers.get(6), numbers.get(7), numbers.get(8));
        this.paramDRange = new ParameterRange(numbers.get(9), numbers.get(10), numbers.get(11));
    }

    public InputRequestData(ParameterRange paramARange,
                            ParameterRange paramBRange,
                            ParameterRange paramCRange,
                            ParameterRange paramDRange) {
        this.paramARange = paramARange;
        this.paramBRange = paramBRange;
        this.paramCRange = paramCRange;
        this.paramDRange = paramDRange;
    }

    public ParameterRange getParamARange() {
        return paramARange;
    }

    public ParameterRange getParamBRange() {
        return paramBRange;
    }

    public ParameterRange getParamCRange() {
        return paramCRange;
    }

    public ParameterRange getParamDRange() {
        return paramDRange;
    }
}
