package org.jpa.study.entity.items;

import lombok.Getter;
import lombok.Setter;
import org.jpa.study.entity.CategoryEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Join 전략, Entity 정규화 ps. SINGLE_TABLE 단일 테이블 전략
@DiscriminatorColumn(name = "ITEM_TYPE") // DTYPE 만들어줌,
@Getter
@Setter
public abstract class ItemEntity {

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

    public void removeStock(int quantity) {
        int resetStock = this.stockQuantity - quantity;
        if (resetStock < 0) {
            // TODO StockException
            System.out.println("Stock 이 부족합니다.");
        }
        this.stockQuantity = quantity;
    }
}
