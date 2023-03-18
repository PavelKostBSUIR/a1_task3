package com.a1.a1.entity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(unique = true)
    private String description;
    @Basic
    private Double amountLC;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private Bun bun;
}