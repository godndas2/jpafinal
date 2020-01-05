package org.jpa.study.entity;

import org.jpa.study.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void 회원가입() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("tester");
        userRepository.save(userEntity);

        List<UserEntity> userEntities = userRepository.findAll();
        userEntities.get(0).getTeam();

    }

}
