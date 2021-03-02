package com.kpi.it01.team1.processors;

import com.kpi.it01.team1.models.TableData;

public interface Processor {
    TableData processTask(TableData input);
}
