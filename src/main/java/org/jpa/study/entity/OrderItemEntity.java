package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.jpa.study.entity.items.ItemEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrderItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "order_price")
    private int orderPrice;

    @Column(name = "count")
    private int count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItems")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    public static OrderItemEntity createOrderItems(ItemEntity itemEntity, int orderPrice, int count) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setItemEntity(itemEntity);
        orderItemEntity.setOrderPrice(orderPrice);
        orderItemEntity.setCount(count);

        itemEntity.removeStock(count);

        return orderItemEntity;
    }
}
