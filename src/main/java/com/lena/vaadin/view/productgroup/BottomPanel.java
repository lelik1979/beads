package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.components.common.ButtonPanelModel;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class BottomPanel extends HorizontalLayout {

    public static final Logger LOG = LoggerFactory.getLogger(BottomPanel.class);

    private ButtonPanelModel model;


    public BottomPanel(ButtonPanelModel model) {
        this.model = model;
        setMargin(true);
        setSizeUndefined();
        setSpacing(true);
        addNewButton();
        addDeleteButton();
    }

    private void addDeleteButton() {
        Button deleteButton = new Button("Удалить", new Button.ClickListener() {
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
        Button newButton = new Button("Добавить", new Button.ClickListener() {
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
