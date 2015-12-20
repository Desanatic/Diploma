package com.khai.training.entity;

import javax.persistence.*;

/**
 * Created by Дубинин on 01.11.2015.
 */
@Entity
@Table(name = "proverb")
public class Proverb {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "proverb")
    private String proverb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProverb() {
        return proverb;
    }

    public void setProverb(String name) {
        this.proverb = name;
    }
}
