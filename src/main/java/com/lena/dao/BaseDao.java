package com.lena.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 28.09.14.
 */
@Repository
@Transactional
public class BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public static final int MAX_ROW_RESULT = 1000;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
