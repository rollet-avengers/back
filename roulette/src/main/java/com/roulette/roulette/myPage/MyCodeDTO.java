package com.roulette.roulette.myPage;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MyCodeDTO {
    private String codeURL;
    private String createdTime;
    private List<CodeDTO> codeList;

}
