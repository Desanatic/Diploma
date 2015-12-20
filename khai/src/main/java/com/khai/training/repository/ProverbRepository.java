package com.khai.training.repository;

import com.khai.training.entity.Proverb;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Дубинин on 01.11.2015.
 */
@Repository
@Transactional
public class ProverbRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Proverb> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Proverb").list();
    }
}
