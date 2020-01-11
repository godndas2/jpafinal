package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.jpa.study.entity.enums.OrderStatus;
import org.jpa.study.entity.zipcode.Address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "order_amount")
    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private DeliveryEntity deliveryEntity;

    @OneToMany(mappedBy = "orderEntity")
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItemEntity orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrderEntity(this);
    }

    public static OrderEntity createOrders(UserEntity userEntity,
                                           DeliveryEntity deliveryEntity,
                                           OrderItemEntity... orderItemEntities) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userEntity);
        orderEntity.setDeliveryEntity(deliveryEntity);

        for (OrderItemEntity orderItemEntity : orderItemEntities) {
            orderEntity.addOrderItem(orderItemEntity);
        }

        orderEntity.setOrderStatus(OrderStatus.주문완료);
        orderEntity.setOrderDate(LocalDateTime.now());

        return orderEntity;
    }

}
