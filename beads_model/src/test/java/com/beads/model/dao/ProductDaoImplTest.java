package com.beads.model.dao;

import com.beads.model.domain.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ProductDaoImplTest extends CommonDaoIT {

    @Autowired
    private ProductDao productDao;

    @Test
    public void deleteProduct() {
        Product p = new Product();
        p.setId(5);
        productDao.removeProduct(p);
    }

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