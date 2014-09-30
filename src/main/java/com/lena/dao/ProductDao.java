package com.lena.dao;

import com.lena.domain.Product;
import java.util.List;

/**
 * Created by Administrator on 13.09.14.
 */
public interface ProductDao {

    List<Product> findAllProducts();

    Product loadProductById(Integer id);

    List<Product> searchProductBySearchString(String searchString);
}
