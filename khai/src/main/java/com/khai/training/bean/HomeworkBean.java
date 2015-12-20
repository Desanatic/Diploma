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
public class HomeworkBean implements Externalizable {
    private Gson gson = new Gson();
    private int homeWorkId;
    private String homeWorkName;
    private int trainingId;
    private String trainingName;
    private int assessment;
    private HomeworkState state;
    private Date dateOfDelivery;

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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(gson.toJson(this.homeWorkId));
        out.writeUTF(gson.toJson(this.assessment));
        out.writeUTF(gson.toJson(this.dateOfDelivery));
        out.writeUTF(gson.toJson(this.homeWorkName));
        out.writeUTF(gson.toJson(this.trainingId));
        out.writeUTF(gson.toJson(this.trainingName));
        out.writeUTF(gson.toJson(this.state));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.homeWorkId = gson.fromJson(in.readUTF(),Integer.class);
        this.assessment = gson.fromJson(in.readUTF(),Integer.class);
        this.dateOfDelivery = gson.fromJson(in.readUTF(),Date.class);
        this.homeWorkName = gson.fromJson(in.readUTF(),String.class);
        this.trainingId = gson.fromJson(in.readUTF(),Integer.class);
        this.trainingName = gson.fromJson(in.readUTF(),String.class);
        this.state = gson.fromJson(in.readUTF(),HomeworkState.class);
    }
}
