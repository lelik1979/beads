package com.beads.web.dao;

import com.beads.web.constant.Constant;
import com.beads.model.domain.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

/**
 * Created by alexey.dranchuk on 31/1/15.
 *
 */

@Repository("web.ProductDaoImpl")
@Primary
public class ProductDaoImpl extends com.beads.model.dao.ProductDaoImpl {

    public static final String BEAN_NAME = "web.ProductDaoImpl";

    @Override
    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    public void removeProduct(Product product) {
        super.removeProduct(product);
    }

    @Override
    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    public void saveOrUpdate(Product product) {
        super.saveOrUpdate(product);
    }
}
