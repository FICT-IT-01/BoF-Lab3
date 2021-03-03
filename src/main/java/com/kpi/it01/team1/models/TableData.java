package com.kpi.it01.team1.models;

import java.util.ArrayList;

public class TableData {
    private final ArrayList<Integer> paramAValues;
    private final ArrayList<Integer> paramBValues;
    private final ArrayList<Integer> paramCValues;
    private final ArrayList<Integer> paramDValues;
    private final ArrayList<Double> paramYValues;

    public TableData(InputRequestData request) {
        this.paramAValues = new ArrayList<>();
        this.paramBValues = new ArrayList<>();
        this.paramCValues = new ArrayList<>();
        this.paramDValues = new ArrayList<>();
        this.paramYValues = new ArrayList<>();

        for (int a = request.getParamARange().getMinValue();
             a <= request.getParamARange().getMaxValue();
             a += request.getParamARange().getStep()){
            for (int b = request.getParamBRange().getMinValue();
                 b <= request.getParamBRange().getMaxValue();
                 b += request.getParamBRange().getStep()) {
                for (int c = request.getParamCRange().getMinValue();
                     c <= request.getParamCRange().getMaxValue();
                     c += request.getParamCRange().getStep()) {
                    for (int d = request.getParamDRange().getMinValue();
                         d <= request.getParamDRange().getMaxValue();
                         d += request.getParamDRange().getStep()) {

                        this.getParamAValues().add(a);
                        this.getParamBValues().add(b);
                        this.getParamCValues().add(c);
                        this.getParamDValues().add(d);
                    }
                }
            }
        }

    }

    public ArrayList<Integer> getParamAValues() {
        return paramAValues;
    }

    public ArrayList<Integer> getParamBValues() {
        return paramBValues;
    }

    public ArrayList<Integer> getParamCValues() {
        return paramCValues;
    }

    public ArrayList<Integer> getParamDValues() {
        return paramDValues;
    }

    public ArrayList<Double> getParamYValues() {
        return paramYValues;
    }
}
