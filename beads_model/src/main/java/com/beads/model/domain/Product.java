package com.beads.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by alexey.dranchuk on 12.09.14.
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String GROUP_ID = "productGroupView.id";

    public static final String ARTIKUL = "artikul";

    public static final String PRICE = "price";

    public static final String PRODUCT_GROUP_VIEW = "productGroupView";

    public static final String GROUP_NAME = "productGroupName";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Product name can't be empty")
    private String name;

    @Column(name = "description", length = 4000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ProductGroupView productGroupView;

    @Column(name="price", precision = 8, scale=2)
    private BigDecimal price;

    @Column(name="product_code")
    private String artikul;

    public Product() {
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getArtikul() {
        return artikul;
    }

    public void setArtikul(String artikul) {
        this.artikul = artikul;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductGroupName() {
        return productGroupView != null ? productGroupView.getName(): "";
    }

    public ProductGroupView getProductGroupView() {
        return productGroupView;
    }

    public void setProductGroupView(ProductGroupView productGroupView) {
        this.productGroupView = productGroupView;
    }

    public ProductPhoto buildProductPhoto(byte[] photo) {
        return new ProductPhoto(id, photo);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Product rhs = (Product) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
