package com.roulette.roulette.myPage.myDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CodeDTO {
    private String codeUrl;
    private String createTime;
    private String codeId;
    private String codeName;

    public CodeDTO (String codeUrl, String createTime, String codeId, String codeName){
        this.codeUrl = codeUrl;
        this.createTime = createTime;
        this.codeId = codeId;
        this.codeName = codeName;
    }
}
