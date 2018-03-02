package com.beads.email.service;

import com.beads.email.dao.OrderDao;
import com.beads.email.dao.OrderDaoImpl;
import com.beads.email.util.Batch;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderStatus;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by alexey.dranchuk on 26/1/15.
 *
 */

@Service
@Transactional
public class EmailSenderService {

    private OrderDao orderDao;
    private EmailSender emailSender;

    @Autowired
    public EmailSenderService(EmailSender emailSender,
                              @Qualifier(value = OrderDaoImpl.BEAN_NAME) OrderDao orderDao) {
        this.emailSender = emailSender;
        this.orderDao = orderDao;
    }

    public void sendEmail(Batch batch) {
        for(Integer orderId : batch.getIds()) {
            Order order = processOrder(orderId);
            updateOrder(order);
        }
    }

    private Order processOrder(Integer orderId) {
        Order order = orderDao.loadOrderById(orderId);
        OrderStatus status = OrderStatus.COMPLETE;
        if (!emailSender.sendEmail(order)) {
            status = OrderStatus.ERROR;
        }
        order.setStatus(status);
        return order;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void updateOrder(Order order) {
        order.setModifyDate(new DateTime());
        orderDao.saveOrUpdate(order);
    }
}
