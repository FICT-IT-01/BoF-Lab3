package com.kpi.it01.team1.processors;

import com.kpi.it01.team1.models.TableData;

public class TaskOneProcessor implements Processor {
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

    private double compute(int a, int b, int c, int d) {
        return Math.sqrt(Math.abs(Math.sin(a) - ((4 * Math.log(b)) / Math.pow(c, d))));
    }
}
