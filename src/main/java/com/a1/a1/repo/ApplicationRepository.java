package com.a1.a1.repo;

import com.a1.a1.entity.domain.Application;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, String> {
    @Override
    @DoIgnore
    Application getById(String s);

    @Override
    @DoIgnore
    Application getOne(String s);
}