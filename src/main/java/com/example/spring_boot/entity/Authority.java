package com.example.spring_boot.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "authorities")
public class Authority {

    @Id
    @Column(name = "authority")
    private String authority;

    @Column(name = "user_id")
    private Long userId;

}
