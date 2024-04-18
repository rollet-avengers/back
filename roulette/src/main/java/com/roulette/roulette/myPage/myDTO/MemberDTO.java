package com.roulette.roulette.myPage.myDTO;

import lombok.*;

@Data
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
