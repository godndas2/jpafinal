package org.jpa.study.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @ManyToMany(mappedBy = "itemEntities")
    private List<CategoryEntity> categoryEntities = new ArrayList<>();
}
