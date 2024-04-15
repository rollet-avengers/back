package com.roulette.roulette.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Entity
@Table(name = "image")
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Image {

    @Id
    @Column(name = "img_id", nullable = false)
    @GeneratedValue
    private Long imgId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_img_id", nullable = false)
    private ReplyImage replyImg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_img_id", nullable = false)
    private PostImage postImg;

    @Column(name = "img_url")
    private String imgUrl;

    @CreatedDate
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "delete_time")
    private LocalDateTime deleteTime;
}
