package com.beads.web.dao;

import com.beads.model.domain.Order;
import java.util.List;

public interface OrderDao extends com.beads.model.dao.OrderDao {


  /**
   * This method get all Orders with passed parameters, which contains in SearchCriteria.
   *
   * @param searchCriteria criteria by search Order
   *
   * @return the result list
   */
  List<Order> getOrdersBySearchCriteria(SearchCriteria searchCriteria);

}
