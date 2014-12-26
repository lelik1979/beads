package com.lena.vaadin.components;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import java.util.Iterator;


/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class BeadWindow extends Window {

    public BeadWindow(String caption) {
        super(caption);
    }

    protected void removePreviousWindow() {
        if (UI.getCurrent() == null)
            return;

        for (Window prevWindow : UI.getCurrent().getWindows()) {
            if (prevWindow.getCaption().equalsIgnoreCase(getCaption()))
                prevWindow.close();
        }
    }
}
