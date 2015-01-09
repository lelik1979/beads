package com.lena.vaadin.components.common;

import com.vaadin.ui.TextField;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
public class BeadsTextField extends TextField {

    public BeadsTextField() {
        setNullRepresentation("");
        setWidth(DefaultComponentSize.WIDTH, Unit.POINTS);
        setImmediate(true);
    }
}
