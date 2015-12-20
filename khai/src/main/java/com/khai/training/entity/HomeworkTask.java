package com.khai.training.entity;

import com.khai.training.entity.util.HomeworkState;

import javax.persistence.*;

/**
 * Created by ������� on 01.11.2015.
 */
@Entity
@Table(name = "homework_task")
public class HomeworkTask {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "homework_id")
    private Integer homeworkId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "chart")
    private String chart;

    @Column(name = "task")
    private String task;

    @Enumerated (value = EnumType.STRING)
    @Column(name = "state")
    private HomeworkState state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public HomeworkState getState() {
        return state;
    }

    public void setState(HomeworkState state) {
        this.state = state;
    }
}
