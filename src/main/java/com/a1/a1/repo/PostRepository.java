package com.a1.a1.repo;

import com.a1.a1.entity.domain.Post;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Override
    @DoIgnore
    Post getById(Long aLong);

    @Override
    @DoIgnore
    Post getOne(Long aLong);

    List<Post> findByPostDateBetween(Date postDateStart, Date postDateEnd);
}