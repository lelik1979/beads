package com.beads.web.dao;

import com.beads.model.domain.Order;
import java.util.List;

public interface OrderDao extends com.beads.model.dao.OrderDao {

  List<Order> getAllOrder();

}
