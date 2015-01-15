package com.lena.vaadin.components;

import com.vaadin.ui.Button;

/**
 * Created by alexey.dranchuk on 15/1/15.
 */
public class BeadsButton extends Button {

    public BeadsButton(String caption, BeadsButtonModel buttonModel, ClickListener clickListener) {
        setData(buttonModel);
        setCaption(caption);
        addClickListener(clickListener);
        setEnabled(buttonModel.isEnabled());
    }
}
