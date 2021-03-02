package com.kpi.it01.team1.models;

import java.util.ArrayList;

public class TableData {
    private final ArrayList<Double> paramAValues;
    private final ArrayList<Double> paramBValues;
    private final ArrayList<Double> paramCValues;
    private final ArrayList<Double> paramDValues;
    private final ArrayList<Double> paramYValues;

    public TableData(InputRequestData request) {
        this.paramAValues = new ArrayList<>();
        this.paramBValues = new ArrayList<>();
        this.paramCValues = new ArrayList<>();
        this.paramDValues = new ArrayList<>();
        this.paramYValues = new ArrayList<>();

        for (double a = request.getParamARange().getMinValue();
             a <= request.getParamARange().getMaxValue();
             a += request.getParamARange().getStep()){
            for (double b = request.getParamBRange().getMinValue();
                 b <= request.getParamBRange().getMaxValue();
                 b += request.getParamBRange().getStep()) {
                for (double c = request.getParamCRange().getMinValue();
                     c <= request.getParamCRange().getMaxValue();
                     c += request.getParamCRange().getStep()) {
                    for (double d = request.getParamDRange().getMinValue();
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

    public ArrayList<Double> getParamAValues() {
        return paramAValues;
    }

    public ArrayList<Double> getParamBValues() {
        return paramBValues;
    }

    public ArrayList<Double> getParamCValues() {
        return paramCValues;
    }

    public ArrayList<Double> getParamDValues() {
        return paramDValues;
    }

    public ArrayList<Double> getParamYValues() {
        return paramYValues;
    }
}
