package com.khai.training.entity;

import javax.persistence.*;

/**
 * Created by ������� on 01.11.2015.
 */
@Entity
@Table(name = "group")
public class Group {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
