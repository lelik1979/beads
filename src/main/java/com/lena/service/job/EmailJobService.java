package com.lena.service.job;

import com.lena.dao.OrderDao;
import com.lena.domain.Order;
import com.lena.domain.OrderStatus;
import com.lena.service.email.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by alexey.dranchuk on 29.09.14.
 *
 */
@Service
@Transactional
public class EmailJobService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailJobService.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "${email.job.schedule}")
    public void processPendingOrders() {
        LOG.debug("EMail service started");
        List<Order> pendingOrders = orderDao.loadPendingOrders();
        for (Order order : pendingOrders) {
            if (emailService.sendEmail(order))
                updateOrderStatusSuccess(order);
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void updateOrderStatusSuccess(Order order) {
        order.setStatus(OrderStatus.COMPLETE);
        orderDao.saveOrUpdate(order);
    }

}
