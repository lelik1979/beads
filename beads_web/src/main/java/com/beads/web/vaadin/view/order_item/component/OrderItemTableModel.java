package com.beads.web.vaadin.view.order_item.component;

import static java.util.Objects.requireNonNull;
import com.beads.model.domain.Order;
import com.beads.model.domain.OrderItem;
import com.vaadin.data.util.BeanItemContainer;
import java.util.List;

public class OrderItemTableModel extends BeanItemContainer<OrderItem> {

  private Order order;

  private Object[] visibleColumns = {OrderItem.ID, OrderItem.PRODUCT_ARTICUL,
      OrderItem.QUANTITY, OrderItem.PRODUCT_PRICE, OrderItem.PRODUCT_NAME};

  public OrderItemTableModel(Order order) {
    super(OrderItem.class);
    this.order = requireNonNull(order);
    init();
  }

  private void init() {
    addNestedContainerProperty(OrderItem.ID);
    addNestedContainerProperty(OrderItem.PRODUCT_ARTICUL);
    addNestedContainerProperty(OrderItem.QUANTITY);
    addNestedContainerProperty(OrderItem.PRODUCT_PRICE);
    addNestedContainerProperty(OrderItem.PRODUCT_NAME);
    populateContainerFullList();
  }

  private void populateContainerFullList() {
    populateContainer(order.getOrderItems());
  }

  private void populateContainer(List<OrderItem> orderItems) {
    removeAllItems();
    addAll(orderItems);
  }

  public void removeOrderItem(OrderItem selectedItem) {
    order.getOrderItems().remove(selectedItem);
    populateContainerFullList();
  }

  public Object[] getVisibleColumns() {
    return visibleColumns;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

}
