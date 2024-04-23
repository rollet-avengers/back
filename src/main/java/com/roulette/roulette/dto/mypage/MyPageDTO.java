package com.roulette.roulette.dto.mypage;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class MyPageDTO {
    private String email;
    private List<PostDTO> postList;

    @Builder
    public MyPageDTO(String email, List<PostDTO> postList) {
        this.email = email;
        this.postList = postList;
    }
}
