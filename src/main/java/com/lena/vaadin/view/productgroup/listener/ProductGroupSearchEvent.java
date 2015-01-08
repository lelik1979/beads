package com.lena.vaadin.view.productgroup.listener;

import com.github.wolfie.blackboard.Event;
import com.github.wolfie.blackboard.Listener;

/**
 * Created by alexey.dranchuk on 8/1/15.
 */
public class ProductGroupSearchEvent implements Event {

    private final String searchString;

    public interface ProductGroupSearchListener extends Listener {
        public void fireSearch(final ProductGroupSearchEvent event);
    }

    public ProductGroupSearchEvent(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }
}
