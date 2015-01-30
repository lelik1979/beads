package com.beads.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexey.dranchuk on 28.09.14.
 *
 */
@Repository
@Transactional
public class BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public static final int MAX_ROW_RESULT = 10000;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
