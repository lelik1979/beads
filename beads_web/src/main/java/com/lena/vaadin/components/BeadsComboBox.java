package com.lena.vaadin.components;

import com.lena.vaadin.components.common.DefaultComponentSize;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class BeadsComboBox<K extends BeadsComboBoxCaption> extends ComboBox {

    public BeadsComboBox() {
        setWidth(DefaultComponentSize.WIDTH, Unit.POINTS);
    }

    @Override
    public Item addItem(Object itemId) {
        final Item retval = super.addItem(itemId);
        setItemCaption(itemId, ((K) itemId).getComboBoxCaption());
        return retval;
    }
}
