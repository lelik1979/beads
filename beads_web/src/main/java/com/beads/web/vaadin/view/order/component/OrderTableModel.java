package com.beads.web.vaadin.view.order.component;

import static com.beads.web.vaadin.view.order.component.OrderTableModel.BEAN_NAME;
import com.beads.model.domain.Order;
import com.beads.web.dao.OrderDao;
import com.beads.web.dao.OrderDaoImpl;
import com.beads.web.dao.SearchCriteria;
import com.beads.web.vaadin.listener.EventBus;
import com.beads.web.vaadin.view.order.listener.OrderChangeEvent;
import com.beads.web.vaadin.view.order.listener.OrderSearchEvent;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.UI;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(BEAN_NAME)
@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderTableModel extends BeanItemContainer<Order> implements OrderSearchEvent.OrderSearchListener,
    ItemClickEvent.ItemClickListener, OrderChangeEvent.OrderChangeListener{

  public static final String BEAN_NAME = "OrderTableModel";

  @Resource(name = OrderDaoImpl.BEAN_NAME)
  private OrderDao orderDao;

  @Autowired
  private OrderWindowModel orderWindowModel;

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

  @Override
  @SuppressWarnings("unchecked")
  public void itemClick(ItemClickEvent event) {
    Order selectedOrder = ((BeanItem<Order>) event.getItem()).getBean();
    if (event.isDoubleClick()) {
      showEditOrder(selectedOrder);
    }
  }

  private void showEditOrder(Order selectedOrder) {
    orderWindowModel.setOrder(selectedOrder);
    OrderWindow orderWindow = new OrderWindow(orderWindowModel);
    UI.getCurrent().addWindow(orderWindow);
  }

  @Override
  public void fireOrderChange(OrderChangeEvent event) {
    removeItem(event.getOrder());
    addItemAt(0, event.getOrder());
  }

  @Override
  public void fireSearch(OrderSearchEvent event) {
    populateContainer(orderDao.getOrdersBySearchCriteria(event.getOrderSearchCriteria()));
  }

  public Object[] getVisibleColumns() {
    return visibleColumns;
  }
}

