package com.beads.web.vaadin.view.productgroup;

import com.beads.web.vaadin.components.BeadsButton;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 29/12/14.
 *
 */
public class ProductGroupBottomPanel extends HorizontalLayout {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupBottomPanel.class);

    private ProductGroupBottomPanelModel model;


    public ProductGroupBottomPanel(ProductGroupBottomPanelModel model) {
        this.model = model;
        setMargin(true);
        setSizeUndefined();
        setSpacing(true);
        addNewButton();
        addDeleteButton();
    }

    private void addDeleteButton() {
        Button deleteButton = new BeadsButton("Удалить", model.getDeleteButtonModel(),new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                LOG.debug("Click on delete item");
                model.deleteButtonClick();
            }
        });
        addComponent(deleteButton);
        setComponentAlignment(deleteButton, Alignment.MIDDLE_RIGHT);
    }

    private void addNewButton() {
        Button newButton = new BeadsButton("Добавить", model.getNewButtonModel(), new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                LOG.debug("Click on new  item");
                model.newButtonClick();
            }
        });
        addComponent(newButton);
        setComponentAlignment(newButton, Alignment.MIDDLE_RIGHT);
    }
}
