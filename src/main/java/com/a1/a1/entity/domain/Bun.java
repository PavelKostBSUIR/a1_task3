package com.a1.a1.entity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "b_un")
public class Bun {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
}