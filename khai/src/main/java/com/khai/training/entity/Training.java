package com.khai.training.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Дубинин on 01.11.2015.
 */
@Entity
@Table(name = "training")
public class Training {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String trainingName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }
}
