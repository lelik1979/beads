package com.lena.dao;

import com.lena.domain.ProductPhoto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductPhotoDaoTest extends CommonDaoIT {

    @Autowired
    private ProductPhotoDao productPhotoDao;

    @Test
    public void testLoadProductPhotoById() throws Exception {
        ProductPhoto pp = productPhotoDao.getProductPhotoById(1);
    }
}