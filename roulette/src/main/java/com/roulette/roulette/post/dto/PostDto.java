package com.roulette.roulette.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private String title;
    private String createdTime;
    private String imgSrc;
}
