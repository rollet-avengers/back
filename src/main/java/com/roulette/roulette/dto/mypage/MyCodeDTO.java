package com.roulette.roulette.dto.mypage;

import lombok.*;

import java.util.List;

@Data
@Setter(AccessLevel.NONE)
@Builder
@RequiredArgsConstructor
public class MyCodeDTO {
    private List<CodeDTO> codeList;

    public MyCodeDTO(List<CodeDTO> codeList) {
        this.codeList = codeList;
    }
}
