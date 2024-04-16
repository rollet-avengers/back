package com.roulette.roulette.myPage;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyPageDTO {
    private String email;
    private List<PostDTO> postList;
}
