package com.a1.a1.entity.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "matDoc", nullable = false)
    private Long matDoc;
    @Basic
    private Boolean authorized;
    @Basic
    private Date docDate;
    @Basic
    private Date postDate;
    @OneToMany
    private List<PostItem> items;
    @Basic
    private Long quantity;
    @ManyToOne
    private User user;
    @Basic
    private String userName;


}