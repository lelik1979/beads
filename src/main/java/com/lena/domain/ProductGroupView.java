package com.lena.domain;

import com.lena.vaadin.components.common.BeadsComboBoxCaption;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexey.dranchuk on 9/1/15.
 */
@Entity
@Table(name = ProductGroup.TABLE_NAME)
public class ProductGroupView implements BeadsComboBoxCaption, Serializable {

    public static final String PARENT_ID = "parentId";

    @Id
    @Column(name = ProductGroup.ID)
    private Integer id;

    @Column(name = ProductGroup.NAME)
    private String name;

    @Column(name = "PARENT_ID")
    private Integer parentId;

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


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroupView that = (ProductGroupView) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ProductGroupBase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public String getComboBoxCaption() {
        return name;
    }
}
