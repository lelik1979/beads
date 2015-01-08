package com.lena.vaadin.view.product.component;

import com.lena.vaadin.view.productgroup.edit.ProductGroupFormLayout;
import com.vaadin.ui.Window;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class ProductWindow extends Window {

    private ProductWindowModel productWindowModel;

    public ProductWindow(ProductWindowModel model) {
        this.productWindowModel = model;
        setCaption("Товар " + model.getProduct().getName());
//        setContent(new ProductGroupFormLayout(model));
        setModal(true);
        setHeight(200, Unit.POINTS);
        setWidth(350, Unit.POINTS);
        setImmediate(true);
        center();
    }
}
