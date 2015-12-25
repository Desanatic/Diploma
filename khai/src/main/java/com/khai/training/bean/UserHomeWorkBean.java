package com.khai.training.bean;

import com.khai.training.entity.*;

/**
 * Created by Vladyslav_Dubinin on 25.12.2015.
 */
public class UserHomeWorkBean {
    private Integer id;
    private User user;
    private Homework homework;
    private HomeworkTask homeworkTask;
    private Training training;
    private Solution solution;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public HomeworkTask getHomeworkTask() {
        return homeworkTask;
    }

    public void setHomeworkTask(HomeworkTask homeworkTask) {
        this.homeworkTask = homeworkTask;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
