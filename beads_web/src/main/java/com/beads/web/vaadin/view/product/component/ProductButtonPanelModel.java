package com.beads.web.vaadin.view.product.component;

import com.beads.model.domain.Product;
import com.beads.web.vaadin.components.BeadsButtonModel;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 10/1/15.
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductButtonPanelModel  {

    public static final Logger LOG = LoggerFactory.getLogger(ProductButtonPanelModel.class);

    @Autowired
    private BeadsButtonModel newButtonModel;

    @Autowired
    private BeadsButtonModel deleteButtonModel;

    @Autowired
    private ProductTableModel productTableModel;

    @Autowired
    private ProductWindowModel productWindowModel;

    public void newButtonClick() {
        productWindowModel.setProduct(new Product());
        ProductWindow productGroupWindow = new ProductWindow(productWindowModel);
        UI.getCurrent().addWindow(productGroupWindow);
    }

    public void deleteButtonClick() {
        productTableModel.deleteSelectedProduct();
    }

    public BeadsButtonModel getNewButtonModel() {
        return newButtonModel;
    }

    public BeadsButtonModel getDeleteButtonModel() {
        return deleteButtonModel;
    }
}
