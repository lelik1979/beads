package com.lena.service;

import com.lena.domain.Product;

import java.util.List;

/**
 * Created by Administrator on 12.09.14.
 */
public interface ProductService {

    Product findProductById(Integer id);

    List<Product> findProducts();

    List<Product> searchProductBySearchString(String searchString);

}
