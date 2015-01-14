package com.lena.dao;

import com.lena.configuration.Constant;
import com.lena.domain.ProductGroup;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 10.10.14.
 */
@Transactional
public interface ProductGroupDao {

    List<ProductGroup> findAllProductGroup();

    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    void saveOrUpdate(ProductGroup productGroup);

    ProductGroup loadProductGroupById(int productGroupId);

    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    void deleteProductGroup(ProductGroup selectedProductGroup);

    List<ProductGroup> findProductGroupsByName(String searchString);
}
