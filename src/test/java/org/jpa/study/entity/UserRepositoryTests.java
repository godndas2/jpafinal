package org.jpa.study.entity;

import org.jpa.study.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    public void setup() {
    }

    @AfterEach
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void 회원가입() throws Exception {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setTeamName("testTeam");
        entityManager.persist(teamEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("tester");
        entityManager.persist(userEntity);

//        userEntity.changeTeam(teamEntity);

        userRepository.save(userEntity);

    }

    @Test
    @Order(2)
    public void 로그인() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("tester");
        entityManager.persist(userEntity);

        List<UserEntity> signinUser = userRepository.findAll();

        userEntity = signinUser.get(0);

        assertThat(userEntity.getUserName()).isEqualTo("tester");
        assertThat(userEntity.getId()).isEqualTo(1);

    }


}
