package com.roulette.roulette.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "code")
public class Code {
    @Id
    @Column(name = "code_id")
    private String codeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "code_url")
    private String codeUrl;

    @Column(name = "confirm")
    private String confirm;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime  updateTime;

    @Column(name = "delete_time")
    private LocalDateTime  deleteTime;

    @Column(name = "code_name")
    private String codeName;
}
