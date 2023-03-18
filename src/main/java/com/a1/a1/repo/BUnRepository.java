package com.a1.a1.repo;

import com.a1.a1.entity.domain.Bun;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BUnRepository extends JpaRepository<Bun, String> {
    @Override
    @DoIgnore
    Bun getById(String s);

    @Override
    @DoIgnore
    Bun getOne(String s);
}