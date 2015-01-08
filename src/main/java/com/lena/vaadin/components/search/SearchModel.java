package com.lena.vaadin.components.search;


import com.github.wolfie.blackboard.Blackboard;
import com.lena.vaadin.listener.EventBus;
import com.lena.vaadin.view.productgroup.listener.ProductGroupSearchEvent;
import com.vaadin.data.util.ObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
@Component
public class SearchModel {

    public static final Logger LOG = LoggerFactory.getLogger(SearchModel.class);

    protected ObjectProperty<String> searchProperty = new ObjectProperty<>("");

    private Blackboard blackboard;

    @Autowired
    protected EventBus eventBus;

    public SearchModel() {
    }

    public SearchModel(Blackboard blackboard) {
        this.blackboard = blackboard;
    }

    public ObjectProperty<String> getSearchProperty() {
        return searchProperty;
    }

    public Object getSearchPropertyValue() {
        return searchProperty.getValue();
    }

    public void processClickEvent() {
        LOG.debug("search value : {}", getSearchPropertyValue());
        if (blackboard != null)
            blackboard.fire(new ProductGroupSearchEvent(searchProperty.getValue()));
        else
            eventBus.fireEvent(new ProductGroupSearchEvent(searchProperty.getValue()));
    }

}
