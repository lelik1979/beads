package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.vaadin.ui.Table;

public class OrderTable extends Table {

  private OrderTableModel orderTableModel;

  public OrderTable(OrderTableModel orderTableModel) {
    this.orderTableModel = orderTableModel;
    setContainerDataSource(orderTableModel);
    setVisibleColumns(orderTableModel.getVisibleColumns());
    setColumnNames();
    setCaption("Список заказов");
    setSizeFull();
    setHeight(400, Unit.POINTS);
    setSelectable(true);
    setImmediate(true);
  }

  private void setColumnNames() {
    setColumnHeader(Order.ID, "№");
    setColumnWidth(Order.ID, 30);
    setColumnHeader(Order.EMAIL, "Имейл заказчика");
    setColumnWidth(Order.EMAIL, 200);
    setColumnHeader(Order.ORDER_DETAILS, "Примечание");
    setColumnWidth(Order.ORDER_DETAILS, 400);
    setColumnHeader(Order.STATUS, "Состояние");
    setColumnWidth(Order.STATUS, 80);
    setColumnHeader(Order.PHONE_NUMBER, "Номер телефона");
    setColumnWidth(Order.PHONE_NUMBER, 90);
    setColumnHeader(Order.MODIFIED_DATE, "Дата заказа");
    setColumnWidth(Order.MODIFIED_DATE, 90);
    setColumnHeader(Order.DELIVERY_ADDRESS, "Адресс доставки");
    setColumnWidth(Order.DELIVERY_ADDRESS, 100);
  }

  private void addListeners() {
    addItemClickListener(orderTableModel);
  }
}
