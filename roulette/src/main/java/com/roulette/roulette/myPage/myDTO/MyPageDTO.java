package com.roulette.roulette.myPage.myDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class MyPageDTO {
    private String email;
    private List<PostDTO> postList;
}
