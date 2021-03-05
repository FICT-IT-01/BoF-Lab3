package com.kpi.it01.team1.data.abstractions;

import com.kpi.it01.team1.models.TaskModel;

public interface DataProvider {
    TaskModel getTaskById(int id);
}
