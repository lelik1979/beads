package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.beads.web.vaadin.listener.EventBus;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class OrderWindowModel {

  private Order order;

  @Autowired
  private EventBus eventBus;

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }
}
