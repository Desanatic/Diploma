package com.khai.training.repository;


import com.khai.training.entity.Solution;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vladyslav_Dubinin on 7/16/2015.
 */
@Repository
@Transactional
public class SolutionRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Solution get(Integer id){
        return  (Solution) sessionFactory.openSession().get(Solution.class, id);
    }

    public Solution getByHomeworkId(Integer id){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Solution.class);
        crit.add(Restrictions.eq("homeworkId", id));

        if(!crit.list().isEmpty()){
            return (Solution) crit.list().get(0);
        }
        return null;
    }

    public Solution getByUserId(Integer id){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Solution.class);
        crit.add(Restrictions.eq("user_id", id));

        if(!crit.list().isEmpty()){
            return (Solution) crit.list().get(0);
        }
        return null;
    }
}
