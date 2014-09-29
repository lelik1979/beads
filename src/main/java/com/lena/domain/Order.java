package com.lena.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Administrator on 28.09.14.
 */
@Entity
@Table(name = "`order`")
@NamedQueries({ @NamedQuery(name = "LOAD_PENDING_ORDERS",
        query = "from Order where status = :status") })
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @NotNull(message = "email can't be empty or null")
    @Column(name = "email")
    private String email;

    @Column(name = "details")
    private String orderDetails;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.PENDING;

    @ManyToMany
    @JoinTable(name = "ORDER_PRODUCT", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
    }

    public Order() {
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer orderId) {
        this.id = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
}
