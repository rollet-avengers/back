package com.roulette.roulette.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
}
