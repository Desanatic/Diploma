package com.khai.training.repository;


import com.khai.training.entity.Training;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Дубинин on 01.11.2015.
 */
@Repository
@Transactional
public class TrainingRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Training get(Integer id){
        return  (Training) sessionFactory.openSession().get(Training.class, id);
    }
}
