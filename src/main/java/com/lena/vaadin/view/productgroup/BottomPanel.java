package com.lena.vaadin.view.productgroup;

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

    private Button newButton;
    private Button deleteButton;
    private BottomPanelModel model;


    public BottomPanel(BottomPanelModel model) {
        this.model = model;
        setMargin(true);
        setSizeUndefined();
        setSpacing(true);
        addNewButton();
        addDeleteButton();
    }

    private void addDeleteButton() {
        deleteButton = new Button("Удалить", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                model.deleteButtonClick();
            }
        });
        addComponent(deleteButton);
        setComponentAlignment(deleteButton, Alignment.MIDDLE_RIGHT);
    }

    private void addNewButton() {
        newButton = new Button("Добавить", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                model.newProductGroupClick();
            }
        });
        addComponent(newButton);
        setComponentAlignment(newButton, Alignment.MIDDLE_RIGHT);
    }
}
