package com.a1.a1.repo;

import com.a1.a1.entity.domain.Item;
import com.a1.a1.entity.domain.Post;
import com.a1.a1.entity.domain.PostItem;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostItemRepository extends JpaRepository<PostItem, Long> {
    @Override
    @DoIgnore
    PostItem getById(Long aLong);

    @Override
    @DoIgnore
    PostItem getOne(Long aLong);
    List<PostItem> findByPost(Post post);
}