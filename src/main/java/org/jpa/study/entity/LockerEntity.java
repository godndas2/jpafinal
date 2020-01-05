package org.jpa.study.entity;

import javax.persistence.*;

@Entity
public class LockerEntity {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "locker")
    private UserEntity userEntity;
}
