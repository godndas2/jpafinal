package org.jpa.study.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jpa.study.entity.enums.DeliveryStatus;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryEntity {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "zip_code", nullable = false)
    private int zipCode;


    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "deliveryEntity", fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryEntities")
    private UserEntity userEntity;

    public DeliveryEntity(String city) {
        this.city = city;
    }
}
