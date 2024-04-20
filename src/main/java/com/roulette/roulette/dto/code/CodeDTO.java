package com.roulette.roulette.dto.code;

import com.roulette.roulette.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CodeDTO {
    private Long codeId;
    private Member member;
    private String codeUrl;
    private boolean confirm;


    @Builder
    public CodeDTO(Long codeId, Member member, String codeUrl, boolean confirm) {
        this.codeId = codeId;
        this.member = member;
        this.codeUrl = codeUrl;
        this.confirm = confirm;
    }
}
