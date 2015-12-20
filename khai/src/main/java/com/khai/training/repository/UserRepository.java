package com.khai.training.repository;

import com.khai.training.entity.Proverb;
import com.khai.training.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public User get(Integer id){
        return  (User) sessionFactory.openSession().get(User.class, id);
    }

    public User get(String name, String surname, String password){
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
        crit.add(Restrictions.eq("name", name));
        crit.add(Restrictions.eq("surname", surname));
        crit.add(Restrictions.eq("password", password));
        if(!crit.list().isEmpty()){
            return (User) crit.list().get(0);
        }
        return null;
    }

    public List<Proverb> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}
