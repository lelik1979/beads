package com.beads.web.vaadin.view.productgroup.edit;

import com.beads.model.dao.ProductGroupDao;
import com.beads.model.domain.ProductGroup;
import com.beads.web.vaadin.view.productgroup.ProductGroupTableModel;
import com.beads.web.dao.ProductGroupDaoImpl;
import com.beads.web.vaadin.components.BeadsButtonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * Created by alexey.dranchuk on 29/12/14.
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Lazy
public class ProductGroupWindowModel {

    private ProductGroup productGroup;

    @Resource(name = ProductGroupDaoImpl.BEAN_NAME)
    private ProductGroupDao productGroupDao;

    @Autowired
    private ProductGroupTableModel productGroupTreeTableModel;

    @Autowired
    private BeadsButtonModel productGroupSaveButtonModel;

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

    public BeadsButtonModel getProductGroupSaveButtonModel() {
        return productGroupSaveButtonModel;
    }
}
