package com.lena.dao;

import com.lena.domain.ProductGroup;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Administrator on 10.10.14.
 */
@Repository(ProductGroupDaoImpl.BEAN_NAME)
public class ProductGroupDaoImpl extends BaseDao implements ProductGroupDao {

    public static final String BEAN_NAME = "ProductGroupDaoImpl";

    @Override
    public List<ProductGroup> findAllProductGroup() {
        Criteria crt = getSession().createCriteria(ProductGroup.class);
        crt.add(Restrictions.isNull(ProductGroup.PARENT_PRODUCT_GROUP));
        crt.addOrder(Order.desc(ProductGroup.ID));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }

    @Override
    public void saveProductGroup(ProductGroup productGroup) {
        getSession().save(productGroup);
    }

    @Override
    public ProductGroup loadProductGroupById(int productGroupId) {
        return (ProductGroup) getSession().get(ProductGroup.class, productGroupId);
    }

    @Override
    public void deleteProductGroup(ProductGroup productGroup) {
        for(ProductGroup pg : productGroup.getChildGroups()) {
            getSession().delete(pg);
        }
        getSession().delete(productGroup);
    }
}
