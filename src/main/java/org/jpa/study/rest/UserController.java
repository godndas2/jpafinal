package org.jpa.study.rest;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.TeamEntity;
import org.jpa.study.entity.UserEntity;
import org.jpa.study.repository.TeamRepository;
import org.jpa.study.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    // TODO DTO 만들자 Controller 에서 Entity 반환은 죄악 + id generate 되는 숫자 체크해봐야함
    @PostMapping(value = "/api/v1/add")
    @Transactional
    public UserEntity add() {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamName("testTeam");
        teamRepository.save(teamEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("tester");
        userEntity.changeTeam(teamEntity);

        return userRepository.save(userEntity);
    }
}
