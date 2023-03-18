package com.a1.a1.entity.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String appAccountName;
    @Basic
    private Boolean isActive;
    @Basic
    private String jobTitle;
    @ManyToOne
    private Application application;
    @ManyToOne
    private Department department;

}