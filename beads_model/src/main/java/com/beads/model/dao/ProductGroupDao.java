package com.beads.model.dao;

import com.beads.model.constant.Constant;
import com.beads.model.domain.ProductGroup;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.10.14.
 *
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
