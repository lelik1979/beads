package com.beads.web.vaadin.view.productgroup.edit;

import com.beads.model.domain.ProductGroup;
import com.beads.web.vaadin.components.BeadsComboBox;
import com.beads.web.vaadin.components.BeadsButton;
import com.beads.web.vaadin.components.common.BeadsBeanFieldGroup;
import com.beads.web.vaadin.components.BeadsTextField;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.*;
import java.util.List;


/**
 * Created by alexey.dranchuk on 7/1/15.
 *
 */
public class ProductGroupFormLayout extends FormLayout implements Button.ClickListener{

    private BeadsBeanFieldGroup<ProductGroup> binder;

    private ProductGroupWindowModel model;

    public ProductGroupFormLayout(ProductGroupWindowModel model) {
        this.model = model;
        binder = new BeadsBeanFieldGroup<>(model.getProductGroup(), ProductGroup.class);
        setSpacing(true);
        setMargin(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        bindId();
        bindName();
        bindParentGroup();
        addButtons();
    }

    private void addButtons() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        hl.setSpacing(true);
        hl.setMargin(true);
        addSaveButton(hl);
        addCloseButton(hl);
        addComponent(hl);
    }

    private void addCloseButton(Layout hl) {
        Button closeButton = new Button("Закрыть", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                closeParentWindow();
            }
        });
        hl.addComponent(closeButton);
    }

    private void addSaveButton(Layout layout) {
        Button saveButton = new BeadsButton("Сохранить", model.getProductGroupSaveButtonModel(),this);
        layout.addComponent(saveButton);
    }

    private void closeParentWindow() {
        ((Window)getParent()).close();
    }

    private void bindParentGroup() {
        List<ProductGroup> parentGroups = model.getProductGroupDao().findAllProductGroup();
        BeadsComboBox parent = binder.buildAndBind("Родительская группа", ProductGroup.PARENT_PRODUCT_GROUP, BeadsComboBox.class);
        parent.addItems(parentGroups);
        addComponent(parent);
    }

    private void bindName() {
        BeadsTextField name = binder.buildAndBind("Имя группы", ProductGroup.NAME, BeadsTextField.class);
        addComponent(name);
    }

    private void bindId() {
        BeadsTextField id = binder.buildAndBind("ID", ProductGroup.ID, BeadsTextField.class);
        id.setEnabled(false);
        addComponent(id);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        try {
            binder.commit();
            model.saveProductGroup();
            closeParentWindow();
        } catch (FieldGroup.CommitException e) {
            Notification.show("Error", "Валидация не прошла", Notification.Type.ERROR_MESSAGE);
        }
    }
}
