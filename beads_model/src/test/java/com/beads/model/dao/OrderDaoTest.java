package com.beads.model.dao;

import com.beads.model.domain.Order;
import com.beads.model.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 28.09.14.
 *
 */

public class OrderDaoTest extends CommonDaoIT {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Test
    public void loadOrderById() {
        Order order = new Order();
        order.setEmail("email3");
        orderDao.saveOrUpdate(order);
        Integer orderId = order.getId();
        order = orderDao.loadOrderById(orderId);
        Assert.assertEquals("Order.id must be as expected", orderId, order.getId());
    }

    @Test
    @Rollback(true)
    public void saveOrder() {
        Order order = new Order();
        order.setEmail("email3");
        order.setOrderDetails("detail3");
        order.setProducts(buildProducts());
        orderDao.saveOrUpdate(order);
    }

    private List<Product> buildProducts() {
        List<Product> products = new LinkedList<>();
        products.add(productDao.loadProductById(3));
        products.add(productDao.loadProductById(4));
        return products;
    }
}
