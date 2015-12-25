package com.khai.training.repository;

import com.khai.training.entity.Homework;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ������� on 01.11.2015.
 */
@Repository
@Transactional
public class HomeworkRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Homework get(Integer id){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Homework.class);
        crit.add(Restrictions.eq("id", id));

        if(!crit.list().isEmpty()){
            return (Homework) crit.list().get(0);
        }
        return null;
    }


    public List<Homework> getByUserId(Integer userId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Homework.class);
        crit.add(Restrictions.eq("userId", userId));

        if(!crit.list().isEmpty()){
            return crit.list();
        }
        return new ArrayList<>();
    }

    public void update(Homework homework){
        sessionFactory.getCurrentSession().update(homework);
    }

}
