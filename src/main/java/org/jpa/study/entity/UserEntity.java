package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

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

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "create_date")
    private LocalDateTime createDT;

    @Column(name = "modify_date")
    private LocalDateTime modifyDT;

    @OneToMany(mappedBy = "userEntity")
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "locker_id")
    private LockerEntity locker;

//    public void changeTeam(TeamEntity team) {
//        this.team = team;
//        if (!team.getUserEntities().contains(this)) {
//            team.getUserEntities().add(this);
//        }
//    }
}
