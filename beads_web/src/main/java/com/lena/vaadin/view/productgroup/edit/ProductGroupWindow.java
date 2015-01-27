package com.lena.vaadin.view.productgroup.edit;

import com.lena.dao.ProductDao;
import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.lena.vaadin.SpringContextHelper;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupWindow extends Window {

    public ProductGroupWindow(ProductGroupWindowModel model) {
        setCaption("Группа товаров");
        setContent(new ProductGroupFormLayout(model));
        setModal(true);
        setHeight(200, Unit.POINTS);
        setWidth(350, Unit.POINTS);
        setImmediate(true);
        center();
    }
}
