package com.kpi.it01.team1.processors;

import com.kpi.it01.team1.models.TableData;

public class TaskTwoProcessor implements Processor {
    @Override
    public TableData processTask(TableData input) {
        for (int i = 0; i < input.getParamAValues().size(); i++) {
            input.getParamYValues().add(compute(input.getParamAValues().get(i),
                    input.getParamBValues().get(i),
                    input.getParamCValues().get(i),
                    input.getParamDValues().get(i)));
        }

        return input;
    }

    private double compute(double a, double b, double c, double d) {
        return ((Math.pow(Math.E, a) + 3 * Math.log10(c))
                / (Math.sqrt(Math.pow(b, c))))*Math.abs(Math.atan(d));
    }
}
