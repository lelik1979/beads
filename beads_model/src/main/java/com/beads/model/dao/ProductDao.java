package com.beads.model.dao;

import com.beads.model.constant.Constant;
import com.beads.model.domain.Product;
import com.beads.model.domain.ProductGroupView;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alexey.dranchuk on 13.09.14.
 *
 */
@Transactional
public interface ProductDao {

    List<Product> findAllProducts();

    Product loadProductById(Integer id);

    List<Product> searchProductBySearchString(String searchString);

    List<Product> loadProductByGroupId(Integer groupId);

    List<ProductGroupView> loadAllProductGroupView();

    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    void saveOrUpdate(Product product);

    @PreAuthorize(Constant.HAS_ROLE_ADMIN)
    void removeProduct(Product product);
}
