package com.a1.a1.entity.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "application")
public class Application {
    @Getter
    @Setter
    @Id
    @Column(name = "id", nullable = false)
    private String id;
}