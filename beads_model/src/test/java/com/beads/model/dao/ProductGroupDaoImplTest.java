package com.beads.model.dao;

import com.beads.model.domain.ProductGroup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class ProductGroupDaoImplTest extends CommonDaoIT {

    @Autowired
    private ProductGroupDao productGroupDao;

    @Test
    public void loadProductGroupByName() {
        List<ProductGroup> pg = productGroupDao.findProductGroupsByName("Чешский");
    }

    @Test
    public void loadProductGroupById() {
        ProductGroup pg = productGroupDao.loadProductGroupById(2);
    }

    @Test
    public void testFindAllProductGroup() throws Exception {
        List<ProductGroup> res = productGroupDao.findAllProductGroup();
    }
}