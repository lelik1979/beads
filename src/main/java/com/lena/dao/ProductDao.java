package com.lena.dao;

import com.lena.configuration.Constant;
import com.lena.domain.Product;
import com.lena.domain.ProductGroupView;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 13.09.14.
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
