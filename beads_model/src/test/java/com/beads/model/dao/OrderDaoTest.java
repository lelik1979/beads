package com.beads.model.dao;

import com.beads.model.builder.OrderBuilder;
import com.beads.model.domain.Order;
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

    private OrderBuilder orderBuilder;

    @Before
    public void init() {
        orderBuilder = new OrderBuilder();
    }

    @Test
    public void loadOrderById() {
        Order expectedOrder = orderBuilder.build();
        orderDao.saveOrUpdate(expectedOrder);

        Order actualOrder = orderDao.loadOrderById(expectedOrder.getId());

        Assert.assertEquals("Actual result must be expected ",
            actualOrder, expectedOrder);
    }
}
