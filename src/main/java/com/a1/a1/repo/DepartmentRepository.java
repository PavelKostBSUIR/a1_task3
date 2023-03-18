package com.a1.a1.repo;

import com.a1.a1.entity.domain.Department;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Override
    @DoIgnore
    Department getById(String s);

    @Override
    @DoIgnore
    Department getOne(String s);
}