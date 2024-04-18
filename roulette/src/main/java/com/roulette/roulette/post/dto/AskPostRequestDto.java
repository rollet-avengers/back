package com.roulette.roulette.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter @Getter
@AllArgsConstructor
public class AskPostRequestDto {
    private String title;
    private String contents;
    private Long member_id;
    private MultipartFile image;
}
