package com.lena.vaadin.view.product.component;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

/**
 * Created by alexey.dranchuk on 10/1/15.
 */
public class ProductPhotoLayout extends VerticalLayout {

    private ProductWindowModel model;

    private Image productPhoto;

    public ProductPhotoLayout(ProductWindowModel model) {
        this.model = model;
        addUploadButton();
        addImage();
    }

    private void addUploadButton() {

    }

    private void addImage() {
        productPhoto = new Image("Фото Продукта", new ExternalResource("getPhoto?id=" + model.getProduct().getId()));
        productPhoto.setWidth(300, Unit.POINTS);
        productPhoto.setHeight(300, Unit.POINTS);
        addComponent(productPhoto);
    }
}
