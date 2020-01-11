package org.jpa.study.rest;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.LockerEntity;
import org.jpa.study.entity.UserEntity;
import org.jpa.study.entity.period.Period;
import org.jpa.study.entity.zipcode.Address;
import org.jpa.study.repository.LockerRepository;
import org.jpa.study.repository.TeamRepository;
import org.jpa.study.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final LockerRepository lockerRepository;

    // TODO DTO 만들자 Controller 에서 Entity 반환은 죄악 + id generate 되는 숫자 체크해봐야함
    @Transactional
    @PostMapping(value = "/api/v1/add")
    public UserEntity add() {

        LockerEntity lockerEntity = new LockerEntity();
        lockerEntity.setName("LOCKNAME");
        lockerRepository.save(lockerEntity);

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("tester");
        userEntity.setLocker(lockerEntity);
        userEntity.setHomeAddress(new Address("12345", "seoul", "street1-1"));
        userEntity.setWorkPeriod(new Period(LocalDateTime.now(),LocalDateTime.now()));

        return userRepository.save(userEntity);
    }

}
