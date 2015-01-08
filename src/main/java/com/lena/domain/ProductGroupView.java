package com.lena.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
@Entity
@Table(name = ProductGroup.TABLE_NAME)
public class ProductGroupView {

    @Id
    @Column(name = ProductGroup.ID)
    private Integer id;

    @Column(name = ProductGroup.NAME)
    private String name;

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

    @Override
    public String toString() {
        return "ProductGroupBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
