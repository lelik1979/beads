package com.lena.dao;

import com.lena.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoImplTest extends CommonDaoIT {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testSearchProductBySearchString() throws Exception {
        List<Product> products = productDao.searchProductBySearchString("имя");
    }

    @Test
    public void testLoadProductsByGroupId() throws Exception {
        List<Product> products = productDao.loadProductByGroupId(2);
    }

    @Test
    public void testLoadProductById() throws Exception {
        Product pr =productDao.loadProductById(1);
    }
}