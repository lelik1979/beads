package com.beads.web.vaadin.view.order.litener;

import com.beads.web.dao.SearchCriteria;
import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;

public class OrderSearchEvent implements Event {

  private SearchCriteria orderSearchCriteria;

  public OrderSearchEvent(SearchCriteria orderSearchCriteria) {
    this.orderSearchCriteria = orderSearchCriteria;
  }

  public interface OrderSearchListener extends Listener {
    void fireSearch(final OrderSearchEvent event);
  }

  public SearchCriteria getOrderSearchCriteria() {
    return orderSearchCriteria;
  }
}
