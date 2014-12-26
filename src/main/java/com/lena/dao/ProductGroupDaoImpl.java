package com.lena.dao;

import com.lena.domain.ProductGroup;
import org.hibernate.Criteria;
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
        crt.add(Restrictions.isNull("parentId"));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }
}
