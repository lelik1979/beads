package com.beads.web.vaadin.view.product.listener;

import com.github.wolfie.blackboard.Listener;
import com.beads.web.vaadin.listener.SearchEvent;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class ProductSearchEvent extends SearchEvent {

    public ProductSearchEvent(String searchString) {
        super(searchString);
    }

    public interface ProductSearchListener extends Listener {
        public void fireSearch(final ProductSearchEvent event);
    }

}
