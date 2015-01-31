package com.beads.web.vaadin.components;

import com.beads.model.ComboBoxCaption;
import com.beads.web.vaadin.components.common.DefaultComponentSize;
import com.vaadin.data.Item;
import com.vaadin.ui.ComboBox;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class BeadsComboBox<K extends ComboBoxCaption> extends ComboBox {

    public BeadsComboBox() {
        setWidth(DefaultComponentSize.WIDTH, Unit.POINTS);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Item addItem(Object itemId) {
        final Item retval = super.addItem(itemId);
        setItemCaption(itemId, ((K) itemId).getComboBoxCaption());
        return retval;
    }
}
