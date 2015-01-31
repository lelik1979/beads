package com.beads.model.dao;

import com.beads.model.domain.ProductGroup;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.10.14.
 *
 */

@Transactional
public interface ProductGroupDao {

    List<ProductGroup> findAllProductGroup();

    void saveOrUpdate(ProductGroup productGroup);

    ProductGroup loadProductGroupById(int productGroupId);

    void deleteProductGroup(ProductGroup selectedProductGroup);

    List<ProductGroup> findProductGroupsByName(String searchString);
}
