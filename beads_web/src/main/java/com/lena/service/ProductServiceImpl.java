package com.lena.service;

import com.lena.dao.ProductDao;
import com.lena.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12.09.14.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findProductById(Integer id) {
        return productDao.loadProductById(id);
    }

    @Override
    public List<Product> findProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public List<Product> searchProductBySearchString(String searchString) {
        return productDao.searchProductBySearchString(searchString);
    }

    @Override
    public List<Product> loadProductByGroupId(Integer groupId) {
        return productDao.loadProductByGroupId(groupId);
    }
}
