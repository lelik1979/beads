package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.components.search.SearchModel;
import com.lena.vaadin.listener.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductGroupViewModel {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupViewModel.class);

    @Autowired
    private ProductGroupSearchModel searchPanelModel;

    @Autowired
    private ProductGroupTableModel productGroupTableModel;

    @Autowired
    private ProductGroupBottomPanelModel bottomPanelModel;

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

    public ProductGroupBottomPanelModel getBottomPanelModel() {
        return bottomPanelModel;
    }
}
