package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.jpa.study.entity.enums.DeliveryStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DeliveryEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "zip_code", nullable = false)
    private int zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @OneToOne(mappedBy = "deliveryEntity")
//    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

}
