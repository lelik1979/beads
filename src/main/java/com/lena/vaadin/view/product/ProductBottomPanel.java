package com.lena.vaadin.view.product;

import com.lena.vaadin.components.BeadsButton;
import com.lena.vaadin.view.product.component.ProductButtonPanelModel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductBottomPanel extends HorizontalLayout {

    public static final Logger LOG = LoggerFactory.getLogger(ProductBottomPanel.class);

    private ProductButtonPanelModel model;


    public ProductBottomPanel(ProductButtonPanelModel model) {
        this.model = model;
        setMargin(true);
        setSizeUndefined();
        setSpacing(true);
        addNewButton();
        addDeleteButton();
    }

    private void addDeleteButton() {
        Button deleteButton = new BeadsButton("Удалить", model.getDeleteButtonModel(), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                LOG.debug("Click on delete item");
                model.deleteButtonClick();
            }
        });
        addComponentWithAlignment(deleteButton);
    }

    private void addNewButton() {
        Button newButton = new BeadsButton("Добавить", model.getNewButtonModel(), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                LOG.debug("Click on new  item");
                model.newButtonClick();
            }
        });
        addComponentWithAlignment(newButton);
    }

    private void addComponentWithAlignment(Button newButton) {
        addComponent(newButton);
        setComponentAlignment(newButton, Alignment.MIDDLE_RIGHT);
    }
}
