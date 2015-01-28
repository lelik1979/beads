package com.beads.model.dao;

import com.beads.model.domain.Order;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by alexey.dranchuk on 28.09.14.
 *
 */
@Transactional
public interface OrderDao {

    int saveOrUpdate(Order shoppingCard);

    Order loadOrderById(int orderId);

    List<Order> loadPendingOrders();

}
