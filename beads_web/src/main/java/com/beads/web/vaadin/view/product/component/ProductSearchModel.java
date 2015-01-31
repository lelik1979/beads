package com.beads.web.vaadin.view.product.component;

import com.beads.web.vaadin.components.search.SearchModel;
import com.beads.web.vaadin.view.product.listener.ProductSearchEvent;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
@Component(ProductSearchModel.BEAN_NAME)
public class ProductSearchModel extends SearchModel {

    public static final String BEAN_NAME = "ProductSearchModel";

    @Override
    public void processClickEvent() {
        LOG.debug("search value : {}", getSearchPropertyValue());
        eventBus.fireEvent(new ProductSearchEvent(searchProperty.getValue()));
    }
}
