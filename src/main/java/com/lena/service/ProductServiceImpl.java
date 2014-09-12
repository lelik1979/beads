package com.lena.service;

import com.lena.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12.09.14.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private static List<Product> products;

    static {
        products = new ArrayList<Product>();
        products.add(new Product(1, "product1"));
        products.add(new Product(2, "product2"));
    }

    @Override
    public List<Product> findProducts() {
        return products;
    }
}
