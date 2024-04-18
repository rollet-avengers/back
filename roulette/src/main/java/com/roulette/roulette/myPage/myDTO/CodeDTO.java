package com.roulette.roulette.myPage.myDTO;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CodeDTO {
    private String codeUrl;
    private LocalDateTime createTime;
    private String codeId;
    private String codeName;

    public CodeDTO (String codeUrl, LocalDateTime createTime, String codeId, String codeName){
        this.codeUrl = codeUrl;
        this.createTime = createTime;
        this.codeId = codeId;
        this.codeName = codeName;
    }
}
