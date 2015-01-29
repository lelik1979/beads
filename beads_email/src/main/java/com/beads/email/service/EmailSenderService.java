package com.beads.email.service;

import com.beads.email.dao.OrderDao;
import com.beads.email.dao.OrderDaoImpl;
import com.beads.email.util.Batch;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public static final Logger LOG = LoggerFactory.getLogger(EmailSenderService.class);

    @Resource(name = OrderDaoImpl.BEAN_NAME)
    private OrderDao orderDao;

    public void
    sendEmail(Batch batch) {
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

    public boolean sendEmail(Order order) {
        LOG.debug("sent email for orderId {}", order.getId());
        return true;
    }
}
