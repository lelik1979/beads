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

  private ObjectProperty<String> searchIdProperty = new ObjectProperty<>("");
  private ObjectProperty<String> searchEmailProperty = new ObjectProperty<>("");
  private ObjectProperty<OrderStatus> searchStatusProperty = new ObjectProperty<>(OrderStatus.COMPLETE);
  private ObjectProperty<String> searchPhoneNumberProperty = new ObjectProperty<>("");
  private ObjectProperty<Date> searchDateProperty = new ObjectProperty<>(new Date());
  private ObjectProperty<String> searchAddressProperty = new ObjectProperty<>("");

  public void processClickEvent() {
    SearchCriteria searchCriteria = new SearchCriteria();
    if (!searchIdProperty.getValue().trim().isEmpty()) {
      searchCriteria.setOrderId(Integer.valueOf(searchIdProperty.getValue().trim()));
    }
      searchCriteria.setEmail(searchEmailProperty.getValue().trim());
      searchCriteria.setStatus(searchStatusProperty.getValue());
      searchCriteria.setPhoneNumber(searchPhoneNumberProperty.getValue().trim());
      Date input = searchDateProperty.getValue();
      searchCriteria.setDateOfOrder(LocalDateTime.ofInstant(input.toInstant(), ZoneId.systemDefault()).withNano(0));
      searchCriteria.setAddress(searchAddressProperty.getValue().trim());
      orderTableModel.fireTableDataChange(searchCriteria);
  }

  public ObjectProperty<String> getSearchIdProperty() {
    return searchIdProperty;
  }

  public ObjectProperty<String> getSearchEmailProperty() {
    return searchEmailProperty;
  }

  public ObjectProperty<OrderStatus> getSearchStatusProperty() {
    return searchStatusProperty;
  }

  public ObjectProperty<String> getSearchPhoneNumberProperty() {
    return searchPhoneNumberProperty;
  }

  public ObjectProperty<Date> getSearchDateProperty() {
    return searchDateProperty;
  }

  public ObjectProperty<String> getSearchAddressProperty() {
    return searchAddressProperty;
  }
}
