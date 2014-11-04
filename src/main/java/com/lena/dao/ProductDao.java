package com.lena.dao;

import com.lena.domain.Product;

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
}
