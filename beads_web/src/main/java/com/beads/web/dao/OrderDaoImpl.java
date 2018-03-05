package com.beads.web.dao;

import com.beads.model.domain.Order;
import com.beads.model.domain.OrderStatus;
import java.util.List;
import org.hibernate.query.NativeQuery;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository(OrderDaoImpl.BEAN_NAME)
@Primary
public class OrderDaoImpl extends com.beads.model.dao.OrderDaoImpl implements OrderDao {

  public static final String BEAN_NAME = "web.OrderDaoImpl";

  @Override
  public List<Order> getAllOrderByStatus(OrderStatus orderStatus) {
    String query = "select * from `order` where status = :status_param order by modified_date asc";
    NativeQuery<Order> nativeQuery = getSession().createNativeQuery(query, Order.class);
    nativeQuery.setParameter("status_param", orderStatus.getDbValue());
    nativeQuery.setMaxResults(MAX_ROW_RESULT);
    return nativeQuery.list();
  }
}
