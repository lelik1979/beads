package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.components.search.SearchModel;
import com.lena.vaadin.view.productgroup.listener.ProductGroupSearchEvent;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 15/1/15.
 */
@Component
public class ProductGroupSearchModel extends SearchModel {

    @Override
    public void processClickEvent() {
        LOG.debug("search value : {}", getSearchPropertyValue());
        eventBus.fireEvent(new ProductGroupSearchEvent(searchProperty.getValue()));
    }
}
