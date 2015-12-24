package com.khai.training.bean;

import com.google.gson.Gson;
import com.khai.training.entity.util.HomeworkState;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * Created by ������� on 10.11.2015.
 */
public class HomeworkBean{
    private int homeWorkId;
    private int taskId;
    private String homeWorkName;
    private int trainingId;
    private String trainingName;
    private int assessment;
    private HomeworkState state;
    private Date dateOfDelivery;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getHomeWorkId() {
        return homeWorkId;
    }

    public void setHomeWorkId(int id) {
        this.homeWorkId = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getHomeWorkName() {
        return homeWorkName;
    }

    public void setHomeWorkName(String homeWorkName) {
        this.homeWorkName = homeWorkName;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public HomeworkState getState() {
        return state;
    }

    public void setState(HomeworkState state) {
        this.state = state;
    }


    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }
}
