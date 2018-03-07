package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.Order;
import com.vaadin.ui.Table;

public class OrderTable extends Table {

  public OrderTable(OrderTableModel orderTableModel) {;
    setContainerDataSource(orderTableModel);
    setVisibleColumns(orderTableModel.getVisibleColumns());
    setColumnNames();
    setCaption("Список заказов");
    setSizeFull();
    setHeight(400, Unit.POINTS);
    setSelectable(true);
    setImmediate(true);
    addListeners();
  }

  private void setColumnNames() {
    setColumnHeader(Order.ID, "№");
    setColumnWidth(Order.ID, 15);
    setColumnHeader(Order.EMAIL, "Емейл заказчика");
    setColumnWidth(Order.EMAIL, 200);
    setColumnHeader(Order.ORDER_DETAILS, "Примечание");
    setColumnHeader(Order.STATUS, "Состояние");
    setColumnWidth(Order.STATUS, 80);
    setColumnHeader(Order.PHONE_NUMBER, "Номер телефона");
    setColumnWidth(Order.PHONE_NUMBER, 100);
    setColumnHeader(Order.MODIFIED_DATE, "Дата заказа");
    setColumnWidth(Order.MODIFIED_DATE, 120);
    setColumnHeader(Order.DELIVERY_ADDRESS, "Адресс доставки");
    setColumnWidth(Order.DELIVERY_ADDRESS, 220);
    setColumnWidth(Order.DELIVERY_ADDRESS, 220);
  }

  private void addListeners() {
    addItemClickListener(orderTableModel);
  }
}
