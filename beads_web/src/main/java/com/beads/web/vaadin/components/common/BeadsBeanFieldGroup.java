package com.beads.web.vaadin.components.common;


import com.beads.web.vaadin.components.BeadsComboBox;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.ui.Field;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class BeadsBeanFieldGroup<T> extends BeanFieldGroup<T> {

    @SuppressWarnings("unchecked")
    public BeadsBeanFieldGroup(final T model, final Class comboBoxClass) {
        super((Class<T>) model.getClass());
        setItemDataSource(model);
        setFieldFactory(new DefaultFieldGroupFieldFactory() {
            @Override
            public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {
                if (type.isAssignableFrom(comboBoxClass) && fieldType.isAssignableFrom(BeadsComboBox.class)) {
                    return (T) new BeadsComboBox();
                }
                return super.createField(type, fieldType);
            }
        });

    }
}
