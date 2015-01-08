package com.lena.vaadin.view.product;

import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.listener.EventBus;
import com.lena.vaadin.view.product.component.ProductTableModel;
import com.lena.vaadin.view.productgroup.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 8/1/15.
 */
@Component
public class ProductViewModel {

    @Autowired
    private SearchModel searchPanelModel;

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ProductTableModel productTableModel;

    public SearchModel getSearchPanelModel() {
        return searchPanelModel;
    }

    public ProductTableModel getProductTableModel() {
        return productTableModel;
    }
}
