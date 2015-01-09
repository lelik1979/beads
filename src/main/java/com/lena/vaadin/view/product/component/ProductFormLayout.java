package com.lena.vaadin.view.product.component;

import com.lena.domain.Product;
import com.lena.domain.ProductGroupView;
import com.lena.vaadin.components.common.BeadsBeanFieldGroup;
import com.lena.vaadin.components.common.BeadsComboBox;
import com.lena.vaadin.components.common.BeadsTextArea;
import com.lena.vaadin.components.common.BeadsTextField;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.ui.*;



/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class ProductFormLayout extends FormLayout {

    private ProductWindowModel model;

    private BeanFieldGroup<Product> binder;

    private BeadsTextField id;

    @PropertyId(Product.PRODUCT_GROUP_VIEW)
    private BeadsComboBox parent;

    private Button saveButton;

    private Button closeButton;

    public ProductFormLayout(ProductWindowModel model) {
        this.model = model;
        setSpacing(true);
        setMargin(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        bindComponents();
        addButtons();
    }

    private void addButtons() {
        HorizontalLayout hl = new HorizontalLayout();
        hl.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        hl.setSpacing(true);
        hl.setMargin(true);
        addSaveButton(hl);
        addCloseButton(hl);
        addComponent(hl);
    }

    private void addCloseButton(Layout hl) {
        closeButton = new Button("Закрыть", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                closeParentWindow();
            }
        });
        hl.addComponent(closeButton);
    }

    private void addSaveButton(HorizontalLayout layout) {
        saveButton = new Button("Сохранить", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                    binder.commit();
                    model.saveProduct();
                    closeParentWindow();
                } catch (FieldGroup.CommitException e) {
                    Notification.show("Error", "Валидация не прошла", Notification.Type.ERROR_MESSAGE);
                }
            }
        });
        layout.addComponent(saveButton);
    }

    private void closeParentWindow() {
        ((Window)getParent()).close();
    }

    private void bindComponents() {
        binder = new BeadsBeanFieldGroup<>(model.getProduct(), ProductGroupView.class);
        bindId();
        bindProductCode();
        bindPrice();
        bindName();
        bindParentGroup();
        bindDescription();
    }

    private Field bindAndAddComponent(String caption, String propertyName, Class componentClass) {
        Field component = binder.buildAndBind(caption, propertyName, componentClass);
        addComponent(component);
        return component;
    }

    private void bindDescription() {
        bindAndAddComponent("Описание", Product.DESCRIPTION, BeadsTextArea.class);
    }

    private void bindPrice() {
        bindAndAddComponent("Цена", Product.PRICE, BeadsTextField.class);
    }

    private void bindProductCode() {
        bindAndAddComponent("Код продукта", Product.PRODUCT_CODE, BeadsTextField.class);
    }

    private void bindParentGroup() {
        parent = (BeadsComboBox<ProductGroupView>) bindAndAddComponent("Группа товара", Product.PRODUCT_GROUP_VIEW, BeadsComboBox.class);
        parent.addItems(model.loadProductGroupViews());
    }

    private void bindName() {
        bindAndAddComponent("Имя продукта", Product.NAME, BeadsTextField.class);
    }

    private void bindId() {
        id = (BeadsTextField) bindAndAddComponent("№", Product.ID, BeadsTextField.class);
        id.setEnabled(false);
    }
}
