package com.beads.email.service;

import com.beads.model.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by alexey.dranchuk on 28/1/15.
 *
 */

@Service
public class OrderEmailProcessor implements ItemProcessor<Order, Order> {

    public static final Logger LOG = LoggerFactory.getLogger(OrderEmailProcessor.class);

    @Override
    public Order process(Order order) throws Exception {
        LOG.debug("Process order {}", order.getId());
        return null;
    }
}
