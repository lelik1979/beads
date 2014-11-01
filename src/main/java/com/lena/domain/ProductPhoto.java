package com.lena.domain;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by Administrator on 31.10.14.
 */
@Entity
@Table(name = "product_photo")
public class ProductPhoto {

    @Id
    @Column(name = "product_id")
    private Integer productId;

    @Lob
    @Column(name = "small_photo", columnDefinition = "tinyblob")
    private Blob smallPhoto;

    @Lob
    @Column(name = "big_photo")
    private byte[] bigPhoto;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Blob getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(Blob smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public byte[] getBigPhoto() {
        return bigPhoto;
    }

    public void setBigPhoto(byte[] bigPhoto) {
        this.bigPhoto = bigPhoto;
    }
}
