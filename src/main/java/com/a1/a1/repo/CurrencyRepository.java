package com.a1.a1.repo;

import com.a1.a1.entity.domain.Currency;
import com.a1.a1.qualifier.DoIgnore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, String> {
    @Override
    @DoIgnore
    Currency getById(String s);

    @Override
    @DoIgnore
    Currency getOne(String s);
}