package com.lena.dao;

import com.lena.domain.ProductPhoto;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 01.11.14.
 */

@Repository
public class ProductPhotoDao extends BaseDao {

    public ProductPhoto getProductPhotoById(int productId) {
        return (ProductPhoto) getSession().get(ProductPhoto.class, productId);
    }

    public void saveOrUpdate(ProductPhoto productPhoto) {
        getSession().saveOrUpdate(productPhoto);
    }
}
