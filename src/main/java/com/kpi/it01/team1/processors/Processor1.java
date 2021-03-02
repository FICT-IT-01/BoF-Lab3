package com.kpi.it01.team1.processors;

import com.kpi.it01.team1.models.InputRequestData;
import com.kpi.it01.team1.models.TableData;

public class Processor1 {
    public TableData process(InputRequestData inputData) {
        return new TableData(inputData);
    }
}
