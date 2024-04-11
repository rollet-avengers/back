package com.roulette.roulette.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Image {

    @Id @GeneratedValue
    private Long imgId;

    @OneToOne(mappedBy = "Image", cascade = CascadeType.ALL)
    private Long postImgId;
    @OneToOne(mappedBy = "Image", cascade = CascadeType.ALL)
    private Long replyImgId;

    private String imgUrl;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
}
