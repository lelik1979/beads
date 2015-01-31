package com.beads.web.vaadin.view.productgroup.listener;

import com.github.wolfie.blackboard.Listener;
import com.beads.web.vaadin.listener.SearchEvent;

/**
 * Created by alexey.dranchuk on 8/1/15.
 *
 */
public class ProductGroupSearchEvent extends SearchEvent {

    public ProductGroupSearchEvent(String searchString) {
        super(searchString);
    }

    public interface ProductGroupSearchListener extends Listener {
        public void fireSearch(final ProductGroupSearchEvent event);
    }

}
