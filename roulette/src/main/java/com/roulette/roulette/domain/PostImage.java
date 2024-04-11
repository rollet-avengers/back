package com.roulette.roulette.domain;

import jakarta.persistence.*;

@Entity
public class PostImage {

    @Id @GeneratedValue
    private Long postImgId;
    @OneToOne
    @JoinColumn(name = "post_id");
    private Long postId;


}
