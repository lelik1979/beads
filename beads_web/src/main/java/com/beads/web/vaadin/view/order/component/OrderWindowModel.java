package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.beads.web.vaadin.components.BeadsButtonModel;
import com.beads.web.vaadin.listener.EventBus;
import com.beads.web.vaadin.view.order.listener.OrderChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderWindowModel {

  private Order order;

  @Autowired
  private EventBus eventBus;

  @Autowired
  private BeadsButtonModel beadsButtonModel;

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  private List<OrderItem> originalOrderItems;

  public void saveOrder() {
    orderDao.saveOrUpdate(order);
    eventBus.fireEvent(new OrderChangeEvent(order));
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
    this.originalOrderItems = new ArrayList<>(order.getOrderItems());
  }

  public void restoreOrderItems() {
    order.setOrderItems(originalOrderItems);
  }

  public BeadsButtonModel getBeadsButtonModel() {
    return beadsButtonModel;
  }

  public List<OrderItem> getOriginalOrderItems() {
    return originalOrderItems;
  }

  public void setOriginalOrderItems(List<OrderItem> originalOrderItems) {
    this.originalOrderItems = originalOrderItems;
  }
}
