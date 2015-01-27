package com.lena.vaadin.view.productgroup.listener;

import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;
import com.lena.vaadin.listener.SearchEvent;

/**
 * Created by alexey.dranchuk on 8/1/15.
 */
public class ProductGroupSearchEvent extends SearchEvent {

    public ProductGroupSearchEvent(String searchString) {
        super(searchString);
    }

    public interface ProductGroupSearchListener extends Listener {
        public void fireSearch(final ProductGroupSearchEvent event);
    }

}
