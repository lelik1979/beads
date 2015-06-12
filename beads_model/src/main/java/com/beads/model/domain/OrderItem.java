package com.beads.model.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author alexey.dranchuk
 */

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal calculateCost() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getItemPrice() {
        return calculateCost();
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        OrderItem oi = (OrderItem) obj;

        return Objects.equals(quantity, oi.getQuantity())
                && Objects.equals(product, oi.getProduct());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Objects.toString(id, "id is null"));
        sb.append(Objects.toString(quantity, "quantity is null"));
        sb.append(Objects.toString(product, "product is null"));
        return sb.toString();
    }
}
