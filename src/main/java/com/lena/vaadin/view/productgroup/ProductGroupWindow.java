package com.lena.vaadin.view.productgroup;

import com.vaadin.ui.*;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupWindow extends Window {


    private Layout layout;

    private ProductGroupWindowModel model;
    private Button saveButton;

    public ProductGroupWindow(ProductGroupWindowModel model) {
        setCaption("Группа товаров");
        this.model = model;
        initLayout();
        addComponents();
        setModal(true);
        setHeight(400, Unit.POINTS);
        setWidth(600, Unit.POINTS);
        setImmediate(true);
        center();
    }

    private void initLayout() {
        layout = new FormLayout();
        setSizeUndefined();
        setContent(layout);
    }

    private void addComponents() {
        layout.addComponent(new Label("sdsd"));
        saveButton = new Button("Сохранить", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                model.saveProductGroup();
                close();
            }
        });
        layout.addComponent(saveButton);
    }
}
