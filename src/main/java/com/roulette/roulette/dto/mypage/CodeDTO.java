package com.roulette.roulette.dto.mypage;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CodeDTO {
    private Long codeId;

    private String htmlCodeUrl;

    private String cssCodeUrl;

    private String jsCodeUrl;

    @Builder
    public CodeDTO(Long codeId, String htmlCodeUrl, String cssCodeUrl, String jsCodeUrl) {
        this.codeId = codeId;
        this.htmlCodeUrl = htmlCodeUrl;
        this.cssCodeUrl = cssCodeUrl;
        this.jsCodeUrl = jsCodeUrl;
    }
}
