package com.beads.model.dao;

import com.beads.model.builder.OrderBuilder;
import com.beads.model.builder.OrderItemBuilder;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by alexey.dranchuk on 28.09.14.
 *
 */

public class OrderDaoTest extends CommonDaoIT {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    private OrderItemBuilder orderItemBuilder;

    private OrderBuilder orderBuilder;

    @Before
    public void init() {
        orderItemBuilder = new OrderItemBuilder();
        orderBuilder = new OrderBuilder();
    }

    @Test
    public void loadOrderByIdFromDB() {
        Order expectedOrder = orderBuilder.build();
        orderDao.saveOrUpdate(expectedOrder);

        Order actualOrder = orderDao.loadOrderById(expectedOrder.getId());

        Assert.assertEquals("Actual result must be expected ",
            actualOrder, expectedOrder);
    }

    @Test
    public void loadOrderById() {
        Order order = new OrderBuilder()
                .withOrderItems(buildOrderItems())
                .build();
        orderDao.saveOrUpdate(order);
        Integer orderId = order.getId();
        order = orderDao.loadOrderById(orderId);
        Assert.assertEquals("Order.id must be as expected", orderId, order.getId());
    }

    @Test
    public void saveOrder() {
        Order order = new OrderBuilder()
                .withOrderItems(buildOrderItems(6))
                .build();
        orderDao.saveOrUpdate(order);
    }

    private List<OrderItem> buildOrderItems(int ... productIds) {
        List<OrderItem> orderItems = new LinkedList<>();
        for (int productId : productIds) {
            orderItems.add(orderItemBuilder.withProduct(productDao.loadProductById(productId)).build());
            orderItemBuilder.reset();
        }
        return orderItems;
    }

}
