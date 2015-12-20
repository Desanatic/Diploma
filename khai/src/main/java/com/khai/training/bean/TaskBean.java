package com.khai.training.bean;

import javax.persistence.Column;

/**
 * Created by Дубинин on 19.11.2015.
 */
public class TaskBean {
    private long id;
    private String trainingName;
    private String chart;
    private String task;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
