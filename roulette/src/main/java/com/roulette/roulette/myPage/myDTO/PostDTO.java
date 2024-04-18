package com.roulette.roulette.myPage.myDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDTO {
    private  Long postId;
    private  String title;
    private LocalDateTime createdTime;
    private  String imgSrc;
    private  String email;

    public PostDTO() {
        // 디폴트 생성자
    }

    public PostDTO(Long postId, String title, LocalDateTime createdTime, String imgSrc, String email) {
        this.postId = postId;
        this.title = title;
        this.createdTime = createdTime;
        this.imgSrc = imgSrc;
        this.email = email;
    }
}