package com.beads.email.service;

import com.beads.model.dao.OrderDao;
import com.beads.model.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

@Component
public class OrderItemReader implements ItemReader<Order> {

    public static final Logger LOG = LoggerFactory.getLogger(OrderItemReader.class);

    @Autowired
    private OrderDao orderDao;

    private int count;

    @Override
    public Order read() throws Exception {

        Order order = new Order();
        order.setId(count++);
        LOG.debug("read Order {}", order);
        return count < 5 ? order : null;
    }
}
