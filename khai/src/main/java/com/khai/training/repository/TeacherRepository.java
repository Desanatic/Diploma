package com.khai.training.repository;

import com.khai.training.entity.Proverb;
import com.khai.training.entity.Teacher;
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
public class TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Teacher get(Integer id){
        return  (Teacher) sessionFactory.openSession().get(Teacher.class, id);
    }

    public List<Teacher> getByUserId(Integer userId){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Teacher.class);
        crit.add(Restrictions.eq("userId", userId));
        if(!crit.list().isEmpty()){
            return crit.list();
        }
        return null;
    }
}
