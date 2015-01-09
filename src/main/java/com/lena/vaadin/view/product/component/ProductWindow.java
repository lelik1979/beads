package com.lena.vaadin.view.product.component;

import com.lena.vaadin.view.productgroup.edit.ProductGroupFormLayout;
import com.vaadin.ui.Window;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class ProductWindow extends Window {

    public ProductWindow(ProductWindowModel model) {
        setCaption("Товар " + model.getProduct().getName());
        setContent(new ProductFormLayout(model));
        setModal(true);
        setHeight(300, Unit.POINTS);
        setWidth(850, Unit.POINTS);
        setImmediate(true);
        center();
    }
}
