package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.SpringContextHelper;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class BottomPanelModel {

    public static final Logger LOG = LoggerFactory.getLogger(BottomPanelModel.class);

    private SpringContextHelper contextHelper;

    private ProductGroupViewModel productGroupViewModel;

    public BottomPanelModel(SpringContextHelper contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void newProductGroupClick() {
        LOG.debug("Clicked on New ProductGroup");
        ProductGroupWindowModel pgwm = new ProductGroupWindowModel(contextHelper);
        pgwm.setProductGroupTreeTableModel(productGroupViewModel.getProductGroupTableModel());
        ProductGroupWindow productGroupWindow = new ProductGroupWindow(pgwm);
        UI.getCurrent().addWindow(productGroupWindow);

    }

    public void setContextHelper(SpringContextHelper contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void setProductGroupViewModel(ProductGroupViewModel productGroupViewModel) {
        this.productGroupViewModel = productGroupViewModel;
    }
}
