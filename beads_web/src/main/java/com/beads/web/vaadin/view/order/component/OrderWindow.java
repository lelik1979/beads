package com.beads.web.vaadin.view.order.component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

public class OrderWindow extends Window {

  public OrderWindow(OrderWindowModel model) {
    setCaption("Заказ № " + model.getOrder().getId());
    setModal(true);
    setHeight(440, Unit.POINTS);
    setWidth(620, Unit.POINTS);
    setImmediate(true);
    center();
    initLayout(model);
  }

  private void initLayout(OrderWindowModel model) {
    HorizontalLayout hl = new HorizontalLayout();
    hl.addComponent(new OrderFormLayout(model));
    setContent(hl);
  }
}
