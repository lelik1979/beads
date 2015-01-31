package com.beads.web.vaadin.view.product;

import com.beads.web.vaadin.view.product.component.ProductButtonPanelModel;
import com.beads.web.vaadin.view.product.component.ProductSearchModel;
import com.beads.web.vaadin.view.product.component.ProductTableModel;
import com.beads.web.vaadin.components.search.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by alexey.dranchuk on 8/1/15.
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductViewModel {

    @Resource(name = ProductSearchModel.BEAN_NAME)
    private SearchModel searchPanelModel;

    @Autowired
    private ProductTableModel productTableModel;

    @Autowired
    private ProductButtonPanelModel productButtonPanelModel;

    public SearchModel getSearchPanelModel() {
        return searchPanelModel;
    }

    public ProductTableModel getProductTableModel() {
        return productTableModel;
    }

    public ProductButtonPanelModel getButtonPanelModel() {
        return productButtonPanelModel;
    }
}
