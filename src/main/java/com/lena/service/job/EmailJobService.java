package com.lena.service.job;

import com.lena.dao.OrderDao;
import com.lena.domain.Order;
import com.lena.domain.OrderStatus;
import com.lena.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Administrator on 29.09.14.
 */
@Service
@Transactional
public class EmailJobService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private EmailService emailService;

    public void processPendingOrders() {
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
