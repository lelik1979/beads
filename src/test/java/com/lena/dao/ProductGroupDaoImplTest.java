package com.lena.dao;

import com.lena.domain.ProductGroup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class ProductGroupDaoImplTest extends CommonDaoIT {

    @Autowired
    private ProductGroupDao productGroupDao;

    @Test
    public void loadProductGroupById() {
        ProductGroup pg = productGroupDao.loadProductGroupById(2);
    }

    @Test
    public void testFindAllProductGroup() throws Exception {
        List<ProductGroup> res = productGroupDao.findAllProductGroup();
    }
}