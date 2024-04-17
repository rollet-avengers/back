package com.roulette.roulette.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    private Long postId;
    private Long memberId;
    private String content;
    private String imgSrc;
}
