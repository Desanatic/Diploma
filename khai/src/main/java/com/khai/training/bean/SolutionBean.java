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
public class SolutionBean {
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

}
