package org.jpa.study.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamEntity {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @OneToMany(mappedBy = "team")
    private List<UserEntity> userEntities = new ArrayList<>();
}
