package com.beads.web.vaadin.view.order_item.component;

import static java.util.Objects.requireNonNull;
import com.beads.model.domain.OrderItem;
import com.vaadin.ui.Table;

public class OrderItemTable extends Table {

  private OrderItemTableModel tableModel;

  public OrderItemTable(OrderItemTableModel tableModel) {
    this.tableModel = requireNonNull(tableModel);
    setContainerDataSource(tableModel);
    setVisibleColumns(tableModel.getVisibleColumns());
    setColumnNames();
    setCaption("Список заказов");
    setSizeFull();
    setHeight(100, Unit.POINTS);
    setWidth(300, Unit.POINTS);
    setSelectable(true);
    setImmediate(true);
  }

  private void setColumnNames() {
    setColumnHeader(OrderItem.ID, "№");
    setColumnWidth(OrderItem.ID, 15);
    setColumnHeader(OrderItem.PRODUCT_ARTIKUL, "Артикул");
    setColumnWidth(OrderItem.PRODUCT_ARTIKUL, 60);
    setColumnHeader(OrderItem.QUANTITY, "Количество");
    setColumnWidth(OrderItem.QUANTITY, 70);
    setColumnHeader(OrderItem.PRODUCT_NAME, "Продукт");
    setColumnHeader(OrderItem.PRODUCT_PRICE, "Цена");
    setColumnWidth(OrderItem.PRODUCT_PRICE, 30);
  }
}
