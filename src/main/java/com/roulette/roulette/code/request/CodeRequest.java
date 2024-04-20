package com.roulette.roulette.code.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CodeRequest {
    private MultipartFile code;
}
