package org.jpa.study.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "create_date")
    private LocalDateTime createDT;

    @Column(name = "modify_date")
    private LocalDateTime modifyDT;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private LockerEntity locker;

    public void changeTeam(TeamEntity team) {
        this.team = team;
        if (!team.getUserEntities().contains(this)) {
            team.getUserEntities().add(this);
        }
    }
}
