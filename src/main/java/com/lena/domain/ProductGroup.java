package com.lena.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Administrator on 10.10.14.
 */
@Entity
@Table(name = "productgroup")
public class ProductGroup {

    public static final String CHILDGROUP = "childGroups";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "productgroup.name can't be empty or null")
    @Column(name = "name", length = 100)
    private String name;

    @OneToMany
    @JoinColumn(table = "productgroup", name = "parent_id")
    private List<ProductGroup> childGroups;

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

    public List<ProductGroup> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<ProductGroup> childGroups) {
        this.childGroups = childGroups;
    }
}
