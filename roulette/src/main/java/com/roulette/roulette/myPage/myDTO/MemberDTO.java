package com.roulette.roulette.myPage.myDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private  String name;
    private  String email;

    public MemberDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public MemberDTO() {

    }
}
