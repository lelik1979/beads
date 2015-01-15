package com.lena.vaadin.components.search;


import com.lena.vaadin.listener.EventBus;
import com.vaadin.data.util.ObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public abstract  class SearchModel {

    public static final Logger LOG = LoggerFactory.getLogger(SearchModel.class);

    protected ObjectProperty<String> searchProperty = new ObjectProperty<>("");

    @Autowired
    protected EventBus eventBus;

    public ObjectProperty<String> getSearchProperty() {
        return searchProperty;
    }

    public Object getSearchPropertyValue() {
        return searchProperty.getValue();
    }

    protected abstract void processClickEvent();


}
