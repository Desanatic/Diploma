package com.khai.training.bean;

import com.google.gson.Gson;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

/**
 * Created by ������� on 19.11.2015.
 */
public class SolutionBean implements Externalizable {
    private Gson gson = new Gson();
    private int id;
    private String chart;
    private String decision;
    private Date dateOfExecution;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Date getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(Date dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(gson.toJson(this.id));
        out.writeUTF(gson.toJson(this.chart));
        out.writeUTF(gson.toJson(this.decision));
        out.writeUTF(gson.toJson(this.dateOfExecution));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = gson.fromJson(in.readUTF(),Integer.class);
        this.chart = gson.fromJson(in.readUTF(),String.class);
        this.decision = gson.fromJson(in.readUTF(),String.class);
        this.dateOfExecution = gson.fromJson(in.readUTF(),Date.class);
    }
}
