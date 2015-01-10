package com.lena.vaadin.view.productgroup;

import com.lena.vaadin.SpringContextHelper;
import com.lena.vaadin.components.common.ButtonPanelModel;
import com.lena.vaadin.view.productgroup.edit.ProductGroupWindow;
import com.lena.vaadin.view.productgroup.edit.ProductGroupWindowModel;
import com.vaadin.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
@Component
public class BottomPanelModel implements ButtonPanelModel {

    public static final Logger LOG = LoggerFactory.getLogger(BottomPanelModel.class);

    private SpringContextHelper contextHelper;

    private ProductGroupViewModel productGroupViewModel;

    public BottomPanelModel() {
    }

    public BottomPanelModel(SpringContextHelper contextHelper) {
        this.contextHelper = contextHelper;
    }

    public void newProductGroupClick() {
        LOG.debug("Clicked on New ProductGroup");
        ProductGroupWindowModel pgwm = new ProductGroupWindowModel(contextHelper.getProductGroupDao());
        pgwm.setProductGroupTreeTableModel(productGroupViewModel.getProductGroupTableModel());
        ProductGroupWindow productGroupWindow = new ProductGroupWindow(pgwm);
        UI.getCurrent().addWindow(productGroupWindow);

    }

    public void setProductGroupViewModel(ProductGroupViewModel productGroupViewModel) {
        this.productGroupViewModel = productGroupViewModel;
    }

    @Override
    public void newButtonClick() {
        newProductGroupClick();
    }

    @Override
    public void deleteButtonClick() {
        productGroupViewModel.getProductGroupTableModel().deleteButtonClick();
    }
}
