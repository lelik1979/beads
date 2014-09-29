package com.lena.dao;

import com.lena.domain.Order;
import com.lena.domain.OrderStatus;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 28.09.14.
 */
@Repository
@Transactional
public class OrderDaoImpl extends BaseDao implements OrderDao {

    public static final Logger LOG = LoggerFactory.getLogger(OrderDaoImpl.class);

    public static final Integer MAX_ROWS = 1000;

    @Override
    public int saveOrUpdate(Order order) {
        getSession().saveOrUpdate(order);
        return order.getId();
    }

    @Override
    public Order loadOrderById(int orderId) {
        return (Order) getSession().get(Order.class, orderId);
    }

    @Override
    public List<Order> loadPendingOrders() {
        return loadOrdersByStatus(OrderStatus.PENDING);
    }

    private List<Order> loadOrdersByStatus(OrderStatus status) {
        Query query  = getSession().getNamedQuery("LOAD_PENDING_ORDERS");
        query.setString("status", status.name());
        query.setMaxResults(MAX_ROWS);
        return query.list();

    }
}
