package com.lena.vaadin.view.productgroup.edit;

import com.lena.domain.ProductGroup;
import com.lena.vaadin.SpringContextHelper;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import java.util.List;


/**
 * Created by alexey.dranchuk on 7/1/15.
 */
public class ProductGroupFormLayout extends FormLayout {

    private BeanFieldGroup<ProductGroup> binder;

    @PropertyId(ProductGroup.ID)
    private TextField id;

    @PropertyId(ProductGroup.NAME)
    private TextField name;

    @PropertyId(ProductGroup.PARENT_PRODUCT_GROUP)
    private ComboBox parent;

    private Button saveButton;

    private Button closeButton;

    private ProductGroupWindowModel model;

    public ProductGroupFormLayout(ProductGroupWindowModel model) {
        this.model = model;
        setSpacing(true);
        setMargin(true);
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        initBinder();
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
        closeButton = new Button("Закрыть", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                closeParentWindow();
            }
        });
        hl.addComponent(closeButton);
    }

    private void addSaveButton(Layout layout) {
        saveButton = new Button("Сохранить", new Button.ClickListener() {
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
        });
        layout.addComponent(saveButton);
    }

    private void closeParentWindow() {
        ((Window)getParent()).close();
    }

    private void initBinder() {
        binder = new BeanFieldGroup<ProductGroup>(ProductGroup.class);
        binder.setFieldFactory(new DefaultFieldGroupFieldFactory() {
            @Override
            public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
                if (type.isAssignableFrom(ProductGroup.class) && fieldType.isAssignableFrom(ComboBox.class)) {
                    return (T) new ComboBox();
                }
                return super.createField(type, fieldType);
            }
        });
        binder.setItemDataSource(model.getProductGroup());
    }

    private void bindParentGroup() {
        List<ProductGroup> parentGroups = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext()).
                getProductGroupDao().findAllProductGroup();
        parent = binder.buildAndBind("Родительская группа", ProductGroup.PARENT_PRODUCT_GROUP, ComboBox.class);
        parent.addItems(parentGroups);
        updateParentCaption(parentGroups);
        addComponent(parent);
    }

    private void updateParentCaption(List<ProductGroup> parentGroups) {
        for(ProductGroup pg : parentGroups) {
            parent.setItemCaption(pg, pg.getName());
        }
    }

    private void bindName() {
        name = binder.buildAndBind("Имя группы", ProductGroup.NAME, TextField.class);
        name.setNullRepresentation("");
        addComponent(name);
    }

    private void bindId() {
        id = binder.buildAndBind("ID", ProductGroup.ID, TextField.class);
        id.setNullRepresentation("");
        id.setEnabled(false);
        addComponent(id);
    }

}
