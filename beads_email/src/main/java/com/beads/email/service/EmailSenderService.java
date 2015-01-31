package com.beads.email.service;

import com.beads.email.dao.OrderDao;
import com.beads.email.dao.OrderDaoImpl;
import com.beads.email.util.Batch;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by alexey.dranchuk on 26/1/15.
 *
 */

@Service
public class EmailSenderService {

    @Resource(name = OrderDaoImpl.BEAN_NAME)
    private OrderDao orderDao;

    @Autowired
    private EmailSender emailSender;

    public void sendEmail(Batch batch) {
        for(Integer orderId : batch.getIds()) {
            Order order = orderDao.loadOrderById(orderId);
            if (sendEmail(order)) {
                setOrderComplete(order);
            }

        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void setOrderComplete(Order order) {
        order.setStatus(OrderStatus.COMPLETE);
        orderDao.saveOrUpdate(order);
    }

    private boolean sendEmail(Order order) {
        return emailSender.sendEmail(order);
    }
}
