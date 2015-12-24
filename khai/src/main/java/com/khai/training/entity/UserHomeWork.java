package com.khai.training.entity;

import javax.persistence.*;

/**
 * Created by PC on 19.12.2015.
 */
@Entity
@Table(name = "user_home_work")
public class UserHomeWork {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "home_work_id")
    private Integer homeworkId;

    @Column(name = "home_work_task_id")
    private Integer homeworkTaskId;

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

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public Integer getHomeworkTaskId() {
        return homeworkTaskId;
    }

    public void setHomeworkTaskId(Integer homeworkTaskId) {
        this.homeworkTaskId = homeworkTaskId;
    }
}
