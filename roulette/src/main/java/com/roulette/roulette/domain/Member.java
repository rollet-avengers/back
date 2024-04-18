package com.roulette.roulette.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name="create_date")
    private LocalDateTime create_time;

    @Column(name="deleted_date")
    private LocalDateTime deleted_time;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
