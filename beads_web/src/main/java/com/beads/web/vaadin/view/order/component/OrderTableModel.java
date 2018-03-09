package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.vaadin.data.util.BeanItemContainer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderTableModel extends BeanItemContainer<Order> {

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  private Object[] visibleColumns = {Order.ID, Order.EMAIL, Order.STATUS,
      Order.PHONE_NUMBER, Order.MODIFIED_DATE, Order.DELIVERY_ADDRESS, Order.ORDER_DETAILS};

  public OrderTableModel() {
    super(Order.class);
  }

  @PostConstruct
  private void init() {
    addNestedContainerProperty(Order.ID);
    addNestedContainerProperty(Order.EMAIL);
    addNestedContainerProperty(Order.STATUS);
    addNestedContainerProperty(Order.PHONE_NUMBER);
    addNestedContainerProperty(Order.MODIFIED_DATE);
    addNestedContainerProperty(Order.DELIVERY_ADDRESS);
    addNestedContainerProperty(Order.ORDER_DETAILS);
    populateContainerFullList();
  }

  private void populateContainerFullList() {
    populateContainer(orderDao.getAllOrder());
  }

  private void populateContainer(List<Order> orders) {
    removeAllItems();
    addAll(orders);
  }

  public Object[] getVisibleColumns() {
    return visibleColumns;
  }

}
