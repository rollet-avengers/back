package com.roulette.roulette.dto.mypage;

import lombok.*;

import java.util.List;

@Data
@Setter(AccessLevel.NONE)
@Builder
@RequiredArgsConstructor
public class MyPageDTO {
    private String email;
    private List<PostDTO> postList;

    public MyPageDTO(String email, List<PostDTO> postList) {
        this.email = email;
        this.postList = postList;
    }
}
