package com.beads.model.domain;

import com.beads.model.ComboBoxCaption;
import com.beads.model.util.NullRepresentor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.10.14.
 *
 */
@Entity
@Table(name = ProductGroup.TABLE_NAME)
public class ProductGroup implements ComboBoxCaption {

    public static final String TABLE_NAME = "productgroup";

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PARENT_PRODUCT_GROUP = "parentProductGroup";

    public static final String PARENT_PRODUCT_NAME = "parentName";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = ID)
    private Integer id;

    @NotNull(message = "productgroup.name can't be empty or null")
    @Column(name = NAME, length = 100)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinColumn(table = ProductGroup.TABLE_NAME, name = "parent_id")
    private List<ProductGroup> childGroups = new ArrayList<>();

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(table = ProductGroup.TABLE_NAME, name = "parent_id")
    private ProductGroup parentProductGroup;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentName() {
        return parentProductGroup != null ? parentProductGroup.getName() : "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductGroup> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<ProductGroup> childGroups) {
        this.childGroups = childGroups;
    }

    public ProductGroup getParentProductGroup() {
        return parentProductGroup;
    }

    public void setParentProductGroup(ProductGroup parentProductGroup) {
        this.parentProductGroup = parentProductGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isChildrenAllowed() {
        return !childGroups.isEmpty();
    }

    @Override
    public String getComboBoxCaption() {
        return NullRepresentor.getStringValue(name);
    }
}
