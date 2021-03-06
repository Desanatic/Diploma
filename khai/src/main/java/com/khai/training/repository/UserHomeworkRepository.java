package com.khai.training.repository;

import com.khai.training.entity.UserHomeWork;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 19.12.2015.
 */
@Repository
@Transactional
public class UserHomeworkRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<UserHomeWork> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from UserHomeWorkBean").list();
    }

    public Integer put(UserHomeWork userHomeWork){
        this.sessionFactory.getCurrentSession().save(userHomeWork);
        return userHomeWork.getId();
    }

    public UserHomeWork getByTaskId(Integer taskId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserHomeWork.class);
        crit.add(Restrictions.eq("homeworkTaskId", taskId));
        if(!crit.list().isEmpty()){
            return (UserHomeWork) crit.list().get(0);
        }
        return null;
    }

    public UserHomeWork getBySolutionId(Integer solutionId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserHomeWork.class);
        crit.add(Restrictions.eq("solutionId", solutionId));
        if(!crit.list().isEmpty()){
            return (UserHomeWork) crit.list().get(0);
        }
        return null;
    }

    public List<UserHomeWork> getByUserId(Integer userId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserHomeWork.class);
        crit.add(Restrictions.eq("userId", userId));
        if(!crit.list().isEmpty()){
            return crit.list();
        }
        return new ArrayList<>();
    }

    public List<UserHomeWork> getByTrainingId(Integer trainingId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserHomeWork.class);
        crit.add(Restrictions.eq("trainingId", trainingId));
        if(!crit.list().isEmpty()){
            return crit.list();
        }
        return new ArrayList<>();
    }
}
