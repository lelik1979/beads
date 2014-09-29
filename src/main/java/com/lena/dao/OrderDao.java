package com.lena.dao;

import com.lena.domain.Order;
import com.lena.domain.ShoppingCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 28.09.14.
 */
@Transactional
public interface OrderDao {

    int saveOrUpdate(Order shoppingCard);

    Order loadOrderById(int orderId);

    List<Order> loadPendingOrders();

}
