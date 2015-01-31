package com.beads.web.vaadin.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

/**
 * Created by alexey.dranchuk on 13/1/15.
 *
 */
public class LogoutClickListener implements Button.ClickListener {

    @Override
    public void buttonClick(Button.ClickEvent event) {
        UI.getCurrent().getPage().setLocation("logout");
    }

}
