package com.lena.vaadin.view.productgroup;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by alexey.dranchuk on 27/12/14.
 */
public class ProductGroupTableModel implements ItemClickEvent.ItemClickListener {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupTableModel.class);

    private List<ProductGroup> productGroups;

    private BeanItemContainer<ProductGroup> container = new BeanItemContainer<ProductGroup>(ProductGroup.class);

    private Object[] visibleColumns = new Object[] {"id", "name", "parentName"};;

    private ProductGroupDao productGroupDao;

    private ProductGroup selectedProductGroup;

    public ProductGroupTableModel(ProductGroupDao productGroups) {
        this.productGroupDao = productGroups;
        populateContainer();
    }

    private void populateContainer() {
        productGroups = productGroupDao.findAllProductGroup();
        container.removeAllItems();
        for(ProductGroup pg : productGroups) {
            container.addBean(pg);
            container.addAll(pg.getChildGroups());
        }
    }

    public BeanItemContainer<ProductGroup> getContainer() {
        return container;
    }

    public Object[] getVisibleColumns() {
        return visibleColumns;
    }

    public void addItemFirst(ProductGroup pg) {
        container.addItemAt(0, pg);
    }

    @Override
    public void itemClick(ItemClickEvent event) {
        selectedProductGroup = ((BeanItem<ProductGroup>)event.getItem()).getBean();
        LOG.trace("Selected productGroup item {}", selectedProductGroup);
    }

    public void deleteButtonClick() {
        if (selectedProductGroup != null) {
            productGroupDao.deleteProductGroup(selectedProductGroup);
            removeProductGroupWithChilds();
        }
        LOG.debug("Deleted productGroup {} with all childs", selectedProductGroup);
        selectedProductGroup = null;
    }

    private void removeProductGroupWithChilds() {
        for(ProductGroup pg : selectedProductGroup.getChildGroups()) {
            getContainer().removeItem(pg);
        }
        getContainer().removeItem(selectedProductGroup);
    }
}
