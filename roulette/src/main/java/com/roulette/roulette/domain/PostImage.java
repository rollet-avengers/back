package com.roulette.roulette.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_img_id")
    private Long postImgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
