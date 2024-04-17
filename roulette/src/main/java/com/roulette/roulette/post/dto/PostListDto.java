package com.roulette.roulette.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PostListDto {
    private Long postId;
    private String title;
    private String createdTime;
    private String imgSrc;
}
