package com.lena.vaadin.view.productgroup;

import com.lena.dao.ProductGroupDao;
import com.lena.domain.ProductGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.event.ItemClickEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

/**
 * Created by alexey.dranchuk on 27/12/14.
 */
public class ProductGroupTableModel implements ItemClickEvent.ItemClickListener {

    public static final Logger LOG = LoggerFactory.getLogger(ProductGroupTableModel.class);

    private HierarchicalContainer container = new HierarchicalContainer();

    private Object[] visibleColumns = new Object[]{ProductGroup.ID, ProductGroup.NAME, ProductGroup.PARENT_PRODUCT_NAME};

    private ProductGroupDao productGroupDao;

    private BeanItem<ProductGroup> selectedProductGroup;

    public ProductGroupTableModel(ProductGroupDao productGroups) {
        this.productGroupDao = productGroups;
        container.addContainerProperty(ProductGroup.ID, Integer.class, null);
        container.addContainerProperty(ProductGroup.NAME, String.class, null);
        container.addContainerProperty(ProductGroup.PARENT_PRODUCT_NAME, String.class, null);
        populateContainer();
    }

    public void populateContainer() {
        container.removeAllItems();
        for (ProductGroup pg : productGroupDao.findAllProductGroup()) {
            BeanItem item = new BeanItem<ProductGroup>(pg);
            container.addItem(item);
            container.setChildrenAllowed(item, pg.isChildrenAllowed());
            propagatePropertyValues(item);
            addChilds(pg.getChildGroups(), item);

        }
    }

    private void propagatePropertyValues(BeanItem item) {
        for (Object propertyId : container.getContainerPropertyIds()) {
            Object value = item.getItemProperty(propertyId).getValue();
            container.getItem(item).getItemProperty(propertyId).setValue(value);
        }
    }

    private void addChilds(List<ProductGroup> childGroups, BeanItem parentGroup) {
        for (ProductGroup pg : childGroups) {
            BeanItem item = new BeanItem<ProductGroup>(pg);
            container.addItem(item);
            container.setChildrenAllowed(item, false);
            propagatePropertyValues(item);
            container.setParent(item, parentGroup);

        }
    }

    public HierarchicalContainer getContainer() {
        return container;
    }

    public Object[] getVisibleColumns() {
        return visibleColumns;
    }


    @Override
    public void itemClick(ItemClickEvent event) {
        selectedProductGroup = (BeanItem<ProductGroup>) event.getItemId();
        LOG.trace("Selected productGroup item {}", selectedProductGroup);
    }

    public void deleteButtonClick() {
        if (selectedProductGroup != null) {
            removeProductGroupWithChilds();
            productGroupDao.deleteProductGroup(selectedProductGroup.getBean());
        }
        LOG.debug("Deleted productGroup {} with all childs", selectedProductGroup);
        selectedProductGroup = null;
    }

    private void removeProductGroupWithChilds() {
        Collection childs = container.getChildren(selectedProductGroup);
        if (childs != null) {
            for(Object childItem : childs) {
                container.removeItem(childItem);
            }
        }
        container.removeItem(selectedProductGroup);
    }
}
