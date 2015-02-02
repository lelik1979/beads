package com.beads.model.dao;

import com.beads.model.builder.OrderBuilder;
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
    public void loadOrderByIdFromDB() {
        Order order = orderDao.loadOrderById(65);
    }

    @Test
    @Rollback(true)
    public void loadOrderById() {
        Order order = new OrderBuilder()
                .withProducts(buildProducts())
                .build();
        orderDao.saveOrUpdate(order);
        Integer orderId = order.getId();
        order = orderDao.loadOrderById(orderId);
        Assert.assertEquals("Order.id must be as expected", orderId, order.getId());
    }

    @Test
    @Rollback(true)
    public void saveOrder() {
        Order order = new OrderBuilder()
                .withProducts(buildProducts())
                .build();
        orderDao.saveOrUpdate(order);
    }

    private List<Product> buildProducts() {
        List<Product> products = new LinkedList<>();
        products.add(productDao.loadProductById(13));
        products.add(productDao.loadProductById(14));
        return products;
    }
}
