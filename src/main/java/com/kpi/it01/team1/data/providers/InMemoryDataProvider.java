package com.kpi.it01.team1.data.providers;

import com.kpi.it01.team1.data.abstractions.DataProvider;
import com.kpi.it01.team1.models.TaskModel;
import com.kpi.it01.team1.processors.TaskOneProcessor;

import java.util.ArrayList;

public class InMemoryDataProvider implements DataProvider {
    private ArrayList<TaskModel> tasks = new ArrayList<>();

    public InMemoryDataProvider() {
        TaskModel task1 = new TaskModel(1, "https://i.imgur.com/aRyvxMD.png", new TaskOneProcessor());
        TaskModel task2 = new TaskModel(2, "https://i.imgur.com/RLHthOf.png", new TaskOneProcessor());
        TaskModel task3 = new TaskModel(3, "https://i.imgur.com/Rhw2Dht.png", new TaskOneProcessor());

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
    }

    @Override
    public TaskModel getTaskById(int id) {
        return tasks.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }
}