package com.lena.vaadin.view.productgroup.edit;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.lena.vaadin.view.productgroup.ProductGroupTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
@Component
public class ProductGroupWindowModel {

    private ProductGroup productGroup;

    @Autowired
    private ProductGroupDao productGroupDao;

    @Autowired
    private ProductGroupTableModel productGroupTreeTableModel;

    public ProductGroup getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroup productGroup) {
        this.productGroup = productGroup;
    }

    public void saveProductGroup() {
        productGroupDao.saveOrUpdate(productGroup);
        productGroupTreeTableModel.populateContainerWithFullList();
    }

    public ProductGroupDao getProductGroupDao() {
        return productGroupDao;
    }
}
