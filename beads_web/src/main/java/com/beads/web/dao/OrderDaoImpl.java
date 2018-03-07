package com.beads.web.dao;

import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import com.beads.model.domain.OrderStatus;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(OrderDaoImpl.BEAN_NAME)
@Primary
public class OrderDaoImpl extends com.beads.model.dao.OrderDaoImpl implements OrderDao {

  public static final String BEAN_NAME = "web.OrderDaoImpl";

  @Override
  public List<Order> getAllOrderByStatus(OrderStatus orderStatus) {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> root = criteriaQuery.from(Order.class);
    Fetch<Order, OrderItem> fetch = root.fetch("orderItems");
    criteriaQuery.where(criteriaBuilder.equal(root.get("status"), orderStatus));
    return getSession().createQuery(criteriaQuery).setMaxResults(MAX_ROW_RESULT).list();
  }

  @Override
  public List<Order> getAllOrder() {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> root = criteriaQuery.from(Order.class);
    root.fetch("orderItems");
    criteriaQuery.select(root);
    return getSession().createQuery(criteriaQuery).setMaxResults(MAX_ROW_RESULT).list();
  }
}
