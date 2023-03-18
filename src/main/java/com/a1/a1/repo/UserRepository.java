package com.a1.a1.repo;

import com.a1.a1.entity.domain.User;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAppAccountName(String appAccountName);

    @Override
    @DoIgnore
    User getById(Long aLong);

    @Override
    @DoIgnore
    User getOne(Long aLong);
}