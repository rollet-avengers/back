package com.roulette.roulette.myPage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CodeDTO {
    private String codeURL;
    private String createTime;
    private String codeId;
    private String codeName;

    public CodeDTO (String codeURL, String createTime, String codeId, String codeName){
        this.codeURL = codeURL;
        this.createTime = createTime;
        this.codeId = codeId;
        this.codeName = codeName;
    }
}
