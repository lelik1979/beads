package com.beads.web.vaadin.view.product.component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class ProductWindow extends Window {

    public ProductWindow(ProductWindowModel model) {
        setCaption("Товар " + model.getProduct().getName());
        setModal(true);
        setHeight(440, Unit.POINTS);
        setWidth(620, Unit.POINTS);
        setImmediate(true);
        center();
        initLayout(model);
    }

    private void initLayout(ProductWindowModel model) {
        HorizontalLayout hl = new HorizontalLayout();
        hl.addComponent(new ProductFormLayout(model));
        hl.addComponent(new ProductPhotoLayout(model));
        setContent(hl);
    }
}
