package com.beads.web.vaadin.view.order.component;

import com.beads.model.domain.OrderStatus;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class SearchOrderPanel extends HorizontalLayout {

  private TextField searchIdField;
  private TextField searchEmailField;
  private ComboBox searchStatusComboBox;
  private TextField searchPhoneNumberField;
  private DateField searchDateField;
  private TextField searchAddressField;
  private Button searchButton;
  private OrderSearchModel orderSearchModel;

  public SearchOrderPanel(OrderSearchModel orderSearchModel) {
    this.orderSearchModel = orderSearchModel;
    setSpacing(true);
    setMargin(true);
    addSearchComponents();
    addSearchButton();
  }

  private void addSearchComponents() {
    addSearchIdField();
    addSearchEmailField();
    addSearchStatusComboBox();
    addSearchPhoneNumberField();
    addSearchDateDateField();
    addSearchAddressField();
  }

  private void addSearchIdField() {
    searchIdField = new TextField("№ заказа", orderSearchModel.getOrderIdProperty());
    searchIdField.addValidator(
        new RegexpValidator("[0-9]{1,10}", "In this field can input only number!"));
    searchIdField.setValidationVisible(true);
    addComponent(searchIdField);
  }

  private void addSearchEmailField() {
    searchEmailField = new TextField("Емейл заказчика", orderSearchModel.getEmailProperty());
    addComponent(searchEmailField);
  }

  private void addSearchStatusComboBox() {
    searchStatusComboBox = new ComboBox("Состояние");
    searchStatusComboBox.addItems(OrderStatus.COMPLETE, OrderStatus.ERROR, OrderStatus.PENDING);
    searchStatusComboBox.setPropertyDataSource(orderSearchModel.getStatusProperty());
    addComponent(searchStatusComboBox);
  }

  private void addSearchPhoneNumberField() {
    searchPhoneNumberField = new TextField("Номер телефона", orderSearchModel.getPhoneNumberProperty());
    addComponent(searchPhoneNumberField);
  }

  private void addSearchDateDateField() {
    searchDateField = new DateField("Дата заказа", orderSearchModel.getDateProperty());
    searchDateField.setResolution(Resolution.SECOND);
    searchDateField.setDateFormat("yyyy-MM-dd HH:mm:ss");
    searchDateField.setRequired(true);
    addComponent(searchDateField);
  }

  private void addSearchAddressField() {
    searchAddressField = new TextField("Адрес", orderSearchModel.getAddressProperty());
    addComponent(searchAddressField);
  }

  private void addSearchButton() {
    searchButton = new Button("Поиск", event -> orderSearchModel.processClickEvent());
    addComponent(searchButton);
  }
}
