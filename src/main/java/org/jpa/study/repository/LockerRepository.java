package org.jpa.study.repository;

import org.jpa.study.entity.LockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<LockerEntity, Long> {
}
