package com.roulette.roulette.dto.mypage;

import lombok.*;

@Data
@RequiredArgsConstructor
public class MemberDTO {
    private  String name;
    private  String email;

    public MemberDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
