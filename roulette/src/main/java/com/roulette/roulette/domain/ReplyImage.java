package com.roulette.roulette.domain;

import jakarta.persistence.*;

@Entity
public class ReplyImage {

    @Id @GeneratedValue
    private Long replyImgId;

    @OneToOne
    @JoinColumn(name = "reply_id");
    private Long replyId;

}
