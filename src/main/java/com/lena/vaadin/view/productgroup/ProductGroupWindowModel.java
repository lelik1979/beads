package com.lena.vaadin.view.productgroup;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.lena.vaadin.SpringContextHelper;

/**
 * Created by alexey.dranchuk on 29/12/14.
 */
public class ProductGroupWindowModel {

    private ProductGroup productGroup = new ProductGroup();
    private ProductGroupDao productGroupDao;
    private ProductGroupTableModel productGroupTreeTableModel;

    public ProductGroupWindowModel() {
    }

    public ProductGroupWindowModel(SpringContextHelper contextHelper) {
        productGroupDao = contextHelper.getProductGroupDao();
    }

    public void saveProductGroup() {
        productGroupDao.saveProductGroup(productGroup);
        productGroupTreeTableModel.addItemFirst(productGroup);
    }

    public void setProductGroupDao(ProductGroupDao productGroupDao) {
        this.productGroupDao = productGroupDao;
    }

    public void setProductGroupTreeTableModel(ProductGroupTableModel productGroupTreeTableModel) {
        this.productGroupTreeTableModel = productGroupTreeTableModel;
    }
}
