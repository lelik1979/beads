package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.OrderStatus;
import com.beads.web.dao.SearchCriteria;
import com.vaadin.data.util.ObjectProperty;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(OrderSearchModel.ORDER_SEARCH_MODEL)
public class OrderSearchModel {

  @Autowired
  private OrderTableModel orderTableModel;

  public static final String ORDER_SEARCH_MODEL = "orderSearchModel";

  private ObjectProperty<String> orderIdProperty = new ObjectProperty<>("");
  private ObjectProperty<String> emailProperty = new ObjectProperty<>("");
  private ObjectProperty<OrderStatus> statusProperty = new ObjectProperty<>(OrderStatus.COMPLETE);
  private ObjectProperty<String> phoneNumberProperty = new ObjectProperty<>("");
  private ObjectProperty<Date> dateProperty = new ObjectProperty<>(new Date());
  private ObjectProperty<String> addressProperty = new ObjectProperty<>("");

  public void processClickEvent() {
    SearchCriteria searchCriteria = new SearchCriteria();
    if (!orderIdProperty.getValue().trim().isEmpty()) {
      searchCriteria.setOrderId(Integer.valueOf(orderIdProperty.getValue().trim()));
    }
      searchCriteria.setEmail(emailProperty.getValue().trim());
      searchCriteria.setStatus(statusProperty.getValue());
      searchCriteria.setPhoneNumber(phoneNumberProperty.getValue().trim());
      Date input = dateProperty.getValue();
      searchCriteria.setDateOfOrder(LocalDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault()).withNano(0));
      searchCriteria.setAddress(addressProperty.getValue().trim());
      orderTableModel.fireTableDataChange(searchCriteria);
  }

  public ObjectProperty<String> getOrderIdProperty() {
    return orderIdProperty;
  }

  public ObjectProperty<String> getEmailProperty() {
    return emailProperty;
  }

  public ObjectProperty<OrderStatus> getStatusProperty() {
    return statusProperty;
  }

  public ObjectProperty<String> getPhoneNumberProperty() {
    return phoneNumberProperty;
  }

  public ObjectProperty<Date> getDateProperty() {
    return dateProperty;
  }

  public ObjectProperty<String> getAddressProperty() {
    return addressProperty;
  }
}
