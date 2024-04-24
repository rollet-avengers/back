package com.roulette.roulette.dto.mypage;

import com.roulette.roulette.entity.Code;
import com.roulette.roulette.entity.Member;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@RequiredArgsConstructor
public class SaveCodeDTO {
    private Long saveCodeId;

    private Member member;

    private Code code;

    @Builder
    public SaveCodeDTO(Long saveCodeId, Member member, Code code) {
        this.saveCodeId = saveCodeId;
        this.member = member;
        this.code = code;
    }
}
