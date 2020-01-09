package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class LockerEntity {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserEntity userEntity;
}
