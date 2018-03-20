package com.beads.web.vaadin.view.order.component;

import static com.beads.web.vaadin.view.order.component.OrderTableModel.BEAN_NAME;
import com.beads.model.domain.Order;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.beads.web.dao.SearchCriteria;
import com.beads.web.vaadin.listener.EventBus;
import com.beads.web.vaadin.view.order.litener.OrderSearchEvent;
import com.vaadin.data.util.BeanItemContainer;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(BEAN_NAME)
@Lazy
@Scope("prototype")
public class OrderTableModel extends BeanItemContainer<Order> implements OrderSearchEvent.OrderSearchListener {

  public static final String BEAN_NAME = "OrderTableModel";

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  @Autowired
  private EventBus eventBus;

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
    eventBus.addListener(this);
  }

  private void populateContainerFullList() {
    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setDateOfOrder(LocalDateTime.now());
    populateContainer(orderDao.getOrdersBySearchCriteria(searchCriteria));
  }

  private void populateContainer(List<Order> orders) {
    removeAllItems();
    addAll(orders);
  }

  public Object[] getVisibleColumns() {
    return visibleColumns;
  }


  @Override
  public void fireSearch(OrderSearchEvent event) {
    populateContainer(orderDao.getOrdersBySearchCriteria(event.getOrderSearchCriteria()));
  }
}
