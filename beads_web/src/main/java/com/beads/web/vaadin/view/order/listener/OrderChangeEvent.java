package com.beads.web.vaadin.view.order.listener;

import com.beads.model.domain.Order;
import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;

public class OrderChangeEvent implements Event {

  private Order order;

  public OrderChangeEvent(Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return order;
  }

  public interface OrderChangeListener extends Listener{
    void fireOrderChange(OrderChangeEvent event);
  }
}
