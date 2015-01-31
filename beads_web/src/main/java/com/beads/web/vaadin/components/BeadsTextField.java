package com.beads.web.vaadin.components;

import com.beads.web.vaadin.components.common.DefaultComponentSize;
import com.vaadin.ui.TextField;

/**
 * Created by alexey.dranchuk on 9/1/15.
 *
 */
public class BeadsTextField extends TextField {

    public BeadsTextField() {
        setNullRepresentation("");
        setWidth(DefaultComponentSize.WIDTH, Unit.POINTS);
        setImmediate(true);
    }
}
