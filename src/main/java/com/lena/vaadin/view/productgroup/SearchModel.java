package com.lena.vaadin.view.productgroup;


import com.github.wolfie.blackboard.Blackboard;
import com.lena.vaadin.view.productgroup.listener.ProductGroupSearchEvent;
import com.vaadin.data.util.ObjectProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 26/12/14.
 */
public class SearchModel {

    public static final Logger LOG = LoggerFactory.getLogger(SearchModel.class);

    private ObjectProperty<String> searchProperty = new ObjectProperty<String>("");

    private Blackboard blackboard;

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
        blackboard.fire(new ProductGroupSearchEvent(searchProperty.getValue()));
    }

}
