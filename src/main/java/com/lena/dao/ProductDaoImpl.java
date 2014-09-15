package com.lena.dao;

import com.lena.domain.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 13.09.14.
 */
@Repository
@Transactional
public class ProductDaoImpl  implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAllProducts() {
        Session session = getSession();
        Criteria crt = session.createCriteria(Product.class);
        return crt.list();
    }

    @Override
    public Product loadProductById(Integer id) {
        return (Product) getSession().get(Product.class, id);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
