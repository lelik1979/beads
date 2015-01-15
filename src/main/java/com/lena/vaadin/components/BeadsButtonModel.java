package com.lena.vaadin.components;

import com.lena.vaadin.SecurityUtils;
import com.vaadin.data.util.ObjectProperty;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 15/1/15.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class BeadsButtonModel extends ObjectProperty<Boolean> {

    public BeadsButtonModel() {
        super(SecurityUtils.userHasAdminRole());
    }

    public void setEnabled(boolean enabled) {
        setValue(enabled);
    }

    public Boolean isEnabled() {
        return  getValue();
    }

}
