package com.beads.web.dao;

import com.beads.model.domain.Order;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(OrderDaoImpl.BEAN_NAME)
@Primary
public class OrderDaoImpl extends com.beads.model.dao.OrderDaoImpl implements OrderDao {

  public static final String BEAN_NAME = "web.OrderDaoImpl";

  @Override
  public List<Order> getAllOrder() {
    CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
    CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    Root<Order> root = criteriaQuery.from(Order.class);
    root.fetch(Order.ORDER_ITEMS);
    criteriaQuery.select(root);
    return getSession().createQuery(criteriaQuery).setMaxResults(MAX_ROW_RESULT).list();
  }
}
