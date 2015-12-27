package com.khai.training.entity;

import javax.persistence.*;

/**
 * Created by PC on 26.12.2015.
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "training_id")
    private Integer trainingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }
}
