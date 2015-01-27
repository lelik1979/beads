package com.lena.vaadin.view.product.listener;

import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;
import com.lena.vaadin.listener.SearchEvent;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class ProductSearchEvent extends SearchEvent {

    public ProductSearchEvent(String searchString) {
        super(searchString);
    }

    public interface ProductSearchListener extends Listener {
        public void fireSearch(final ProductSearchEvent event);
    }

}
