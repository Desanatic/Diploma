package com.khai.training.repository;

import com.khai.training.entity.*;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ������� on 01.11.2015.
 */
@Repository
@Transactional
public class HomeworkTaskRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Integer put(HomeworkTask homeworkTask ){
        this.sessionFactory.getCurrentSession().save(homeworkTask);
        return homeworkTask.getId();
    }

    public HomeworkTask get(Integer id){
        Object hwt = sessionFactory.openSession().get(HomeworkTask.class, id);
        if(hwt != null){
            return  (HomeworkTask) hwt;
        }
       return null;
    }


    public List<HomeworkTask> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from HomeworkTask").list();
    }

    public HomeworkTask get(Integer homeworkId, Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(HomeworkTask.class);
        crit.add(Restrictions.eq("homeworkId", homeworkId));
        crit.add(Restrictions.eq("userId", userId));
        if (!crit.list().isEmpty()) {
            return (HomeworkTask) crit.list().get(0);
        }
        return null;
    }

    public void update(HomeworkTask homeworkTask){
        sessionFactory.getCurrentSession().update(homeworkTask);
    }
}
