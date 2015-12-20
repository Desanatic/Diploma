package com.khai.training.repository;

import com.khai.training.entity.HomeworkTask;
import com.khai.training.entity.Proverb;
import com.khai.training.entity.Solution;
import com.khai.training.entity.User;
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

    public User get(Integer id){
        return  (User) sessionFactory.openSession().get(HomeworkTask.class, id);
    }


    public List<HomeworkTask> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from HomeworkTask").list();
    }

    public HomeworkTask get(Integer homeworkId, Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(HomeworkTask.class);
        crit.add(Restrictions.eq("homework_id", homeworkId));
        crit.add(Restrictions.eq("user_id", userId));
        if (!crit.list().isEmpty()) {
            return (HomeworkTask) crit.list().get(0);
        }
        return null;
    }
}
