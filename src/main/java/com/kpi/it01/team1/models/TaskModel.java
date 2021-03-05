package com.kpi.it01.team1.models;

import com.kpi.it01.team1.processors.Processor;

public class TaskModel {
    private int id;
    private String imageLink;
    private Processor processor;

    public TaskModel(int id, String imageLink, Processor processor) {
        this.id = id;
        this.imageLink = imageLink;
        this.processor = processor;
    }

    public int getId() {
        return id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Processor getProcessor() {
        return processor;
    }
}
