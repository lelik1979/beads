package com.beads.web.vaadin.view.order;

import com.beads.web.vaadin.SpringContextHelper;
import com.beads.web.vaadin.view.order.component.OrderTable;
import com.beads.web.vaadin.view.order.component.SearchOrderPanel;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class OrderView extends Panel implements View {

  public static final String VIEW_NAME = "orderView";

 private OrderViewModel orderViewModel;
 private Layout layout;

 private void addComponents() {
   SearchOrderPanel searchOrderPanel = new SearchOrderPanel(orderViewModel.getOrderSearchModel());
   searchOrderPanel.setCaption("Введите необходимые парамерры для поиска :");
   layout.addComponent(searchOrderPanel);
   OrderTable orderTable = new OrderTable(orderViewModel.getOrderTableModel());
   layout.addComponent(orderTable);
 }

  private void initLayout() {
    layout = new VerticalLayout();
    setContent(layout);
  }

  @Override
  public void enter(ViewChangeListener.ViewChangeEvent event) {
    setCaption("Работа с заказами");
    SpringContextHelper contextHelper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
    this.orderViewModel = contextHelper.getBean(OrderViewModel.class);
    initLayout();
    addComponents();
    setSizeFull();
  }
}
