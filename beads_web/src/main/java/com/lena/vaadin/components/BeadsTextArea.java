package com.lena.vaadin.components;

import com.lena.vaadin.components.common.DefaultComponentSize;
import com.vaadin.ui.TextArea;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class BeadsTextArea extends TextArea {

    public BeadsTextArea() {
        setWidth(DefaultComponentSize.WIDTH, Unit.POINTS);
        setNullRepresentation("");
    }
}
