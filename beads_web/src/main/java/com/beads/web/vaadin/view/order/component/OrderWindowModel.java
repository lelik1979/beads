package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import java.util.ArrayList;
import java.util.List;

public class OrderWindowModel {

  public OrderWindowModel(Order order) {
    this.order = order;
    this.originalOrderItems = new ArrayList<>(order.getOrderItems());
  }

  private Order order;

  private List<OrderItem> originalOrderItems;

  public Order getOrder() {
    return order;
  }

  public void restoreOrderItems() {
    order.setOrderItems(originalOrderItems);
  }
}
