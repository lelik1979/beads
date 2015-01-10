package com.lena.vaadin.view.product;

import com.lena.vaadin.components.common.ButtonPanelModel;
import com.lena.vaadin.view.product.component.ProductButtonPanelModel;
import com.lena.vaadin.view.product.component.ProductSearchModel;
import com.lena.vaadin.view.product.component.ProductTableModel;
import com.lena.vaadin.components.search.SearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by alexey.dranchuk on 8/1/15.
 */
@Component
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

    public ButtonPanelModel getButtonPanelModel() {
        return productButtonPanelModel;
    }
}
