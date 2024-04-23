package com.roulette.roulette.code.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CodeRequest {
    private Long postId;
    private String html;
    private String css;
    private String js;
}
