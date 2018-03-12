package com.beads.web.dao;

import com.beads.model.domain.OrderStatus;
import java.time.LocalDateTime;

public class SearchCriteria {

  private Integer orderId;
  private String email;
  private OrderStatus status;
  private String phoneNumber;
  private LocalDateTime dateOfOrder;
  private String address;

  public boolean isOrderIdNotNull() {
    return orderId != null;
  }

  public boolean isEmailNotNull() {
    return email != null && !email.isEmpty();
  }

  public boolean isStatusNotNull() {
    return status != null && !status.getDbValue().isEmpty();
  }

  public boolean isPhoneNumberNotNull() {
    return phoneNumber != null && !phoneNumber.isEmpty();
  }

  public boolean isAddressNotNull() {
    return address != null && !address.isEmpty();
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public LocalDateTime getDateOfOrder() {
    return dateOfOrder;
  }

  public void setDateOfOrder(LocalDateTime dateOfOrder) {
    this.dateOfOrder = dateOfOrder;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }
}
