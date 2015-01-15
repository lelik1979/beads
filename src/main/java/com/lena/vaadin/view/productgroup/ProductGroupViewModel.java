package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.components.search.SearchModel;
import com.lena.vaadin.listener.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
@Component(ProductGroupViewModel.BEAN_NAME)
public class ProductGroupViewModel {

    public static final String BEAN_NAME = "ProductGroupViewModel";

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupViewModel.class);

    @Autowired
    private ProductGroupSearchModel searchPanelModel;

    @Autowired
    private ProductGroupTableModel productGroupTableModel;

    @Autowired
    private BottomPanelModel bottomPanelModel;

    @Autowired
    private EventBus eventBus;


    @PostConstruct
    private void initListeners() {
        eventBus.addListener(productGroupTableModel);
    }

    public SearchModel getSearchPanelModel() {
        return searchPanelModel;
    }

    public ProductGroupTableModel getProductGroupTableModel() {
        return productGroupTableModel;
    }

    public BottomPanelModel getBottomPanelModel() {
        return bottomPanelModel;
    }
}
