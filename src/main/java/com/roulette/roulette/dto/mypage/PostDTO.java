package com.roulette.roulette.dto.mypage;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Setter(AccessLevel.NONE)
@Builder
@RequiredArgsConstructor
public class PostDTO {
    private  Long postId;
    private  String title;
    private LocalDateTime createdTime;
    private  String imgSrc;
    private  String email;

    public PostDTO(Long postId, String title, LocalDateTime createdTime, String imgSrc, String email) {
        this.postId = postId;
        this.title = title;
        this.createdTime = createdTime;
        this.imgSrc = imgSrc;
        this.email = email;
    }
}