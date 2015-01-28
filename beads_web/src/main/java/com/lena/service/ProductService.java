package com.lena.service;

import com.beads.model.domain.Product;
import java.util.List;

/**
 * Created by alexey.dranchuk on 12.09.14.
 *
 */
public interface ProductService {

    Product findProductById(Integer id);

    List<Product> findProducts();

    List<Product> searchProductBySearchString(String searchString);

    List<Product> loadProductByGroupId(Integer groupId);
}
