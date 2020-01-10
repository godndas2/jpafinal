package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;
import org.jpa.study.entity.period.Period;
import org.jpa.study.entity.zipcode.Address;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    // 기간
    @Embedded
    private Period workPeriod;

    // 주소
    @Embedded
    private Address homeAddress;

    @OneToMany(mappedBy = "userEntity")
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locker_id")
    private LockerEntity locker;

    @OneToMany(mappedBy = "userEntity")
    private List<DeliveryEntity> deliveryEntities = new ArrayList<>();

//    public void changeTeam(TeamEntity team) {
//        this.team = team;
//        if (!team.getUserEntities().contains(this)) {
//            team.getUserEntities().add(this);
//        }
//    }
}
