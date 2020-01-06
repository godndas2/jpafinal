package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "orderItems")
    private OrderEntity orderEntity;
}
