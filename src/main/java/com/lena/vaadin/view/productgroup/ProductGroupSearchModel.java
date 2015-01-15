package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.components.search.SearchModel;
import com.lena.vaadin.view.productgroup.listener.ProductGroupSearchEvent;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 15/1/15.
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductGroupSearchModel extends SearchModel {

    @Override
    public void processClickEvent() {
        LOG.debug("search value : {}", getSearchPropertyValue());
        eventBus.fireEvent(new ProductGroupSearchEvent(searchProperty.getValue()));
    }
}
