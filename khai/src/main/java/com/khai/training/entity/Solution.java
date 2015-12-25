package com.khai.training.entity;

import javax.persistence.*;

/**
 * Created by ������� on 11.11.2015.
 */

@Entity
@Table(name = "solution")
public class Solution {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "chart")
    private String chart;

    @Column(name = "decision")
    private String decision;

    @Column(name = "assessment")
    private Integer assessment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }
}
