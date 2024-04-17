package com.roulette.roulette.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class AskPostRequestDto {
    String title;
    String contents;
}
