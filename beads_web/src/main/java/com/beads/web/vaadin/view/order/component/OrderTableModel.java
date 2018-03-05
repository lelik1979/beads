package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.beads.model.domain.OrderStatus;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderTableModel extends BeanItemContainer<Order> implements ItemClickEvent.ItemClickListener {

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  private Order selectedOrder;

  private Object[] visibleColumns = {Order.ID, Order.EMAIL, Order.ORDER_DETAILS,
      Order.STATUS, Order.PHONE_NUMBER, Order.MODIFIED_DATE, Order.DELIVERY_ADDRESS};

  public OrderTableModel() {
    super(Order.class);
  }

  @PostConstruct
  private void init() {
    addNestedContainerProperty(Order.ID);
    addNestedContainerProperty(Order.EMAIL);
    addNestedContainerProperty(Order.ORDER_DETAILS);
    addNestedContainerProperty(Order.STATUS);
    addNestedContainerProperty(Order.PHONE_NUMBER);
    addNestedContainerProperty(Order.MODIFIED_DATE);
    addNestedContainerProperty(Order.DELIVERY_ADDRESS);
    populateContainerFullList();
  }

  private void populateContainerFullList() {
    populateContainer(orderDao.getAllOrderByStatus(OrderStatus.PENDING));
  }

  private void populateContainer(List<Order> orders) {
    removeAllItems();
    addAll(orders);
  }


  public Object[] getVisibleColumns() {
    return visibleColumns;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void itemClick(ItemClickEvent event) {
//      selectedOrder = ((BeanItem<Order>) event.getItem()).getBean();
//      if (event.isDoubleClick()) {
//        selectedOrder
//      }
  }
}
