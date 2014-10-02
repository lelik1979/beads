package com.lena.dao;

import com.lena.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ProductDaoImplTest extends CommonDaoIT {

    @Autowired
    private ProductDao productDao;


    @Test
    public void testLoadProductById() throws Exception {
        Product pr =productDao.loadProductById(1);
    }
}