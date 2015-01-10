package com.lena.vaadin.view.product.component;

import com.lena.domain.Product;
import com.lena.vaadin.components.common.ButtonPanelModel;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 10/1/15.
 */
@Component
public class ProductButtonPanelModel implements ButtonPanelModel {

    public static final Logger LOG = LoggerFactory.getLogger(ProductButtonPanelModel.class);

    @Autowired
    private ProductTableModel productTableModel;

    @Autowired
    private ProductWindowModel productWindowModel;

    @Override
    public void newButtonClick() {
        productWindowModel.setProduct(new Product());
        ProductWindow productGroupWindow = new ProductWindow(productWindowModel);
        UI.getCurrent().addWindow(productGroupWindow);
    }

    @Override
    public void deleteButtonClick() {
        productTableModel.deleteSelectedProduct();
    }
}
