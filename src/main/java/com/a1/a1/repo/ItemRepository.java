package com.a1.a1.repo;

import com.a1.a1.entity.domain.Item;
import com.a1.a1.entity.domain.User;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    @DoIgnore
    Item getById(Long aLong);

    @Override
    @DoIgnore
    Item getOne(Long aLong);

    Item findByDescription(String description);
}