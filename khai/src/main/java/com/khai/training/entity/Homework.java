package com.khai.training.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ������� on 01.11.2015.
 */
@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "training_id")
    private Integer trainingId;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_delivery")
    private Date dateOfDelivery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Integer trainingId) {
        this.trainingId = trainingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

}
