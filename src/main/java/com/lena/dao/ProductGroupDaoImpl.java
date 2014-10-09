package com.lena.dao;

import com.lena.domain.ProductGroup;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by Administrator on 10.10.14.
 */
@Repository
public class ProductGroupDaoImpl extends BaseDao implements ProductGroupDao {

    @Override
    public List<ProductGroup> findAllProductGroup() {
        Criteria crt = getSession().createCriteria(ProductGroup.class);
        crt.add(Restrictions.isNotEmpty(ProductGroup.CHILDGROUP));
        crt.setMaxResults(MAX_ROW_RESULT);
        return crt.list();
    }
}
