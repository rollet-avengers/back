package com.roulette.roulette.aboutlogin.domaindto;

import lombok.Data;
import lombok.Getter;


@Data
public class MemberDto {

        private String email;
        private String name;


        public MemberDto(String email, String name) {
            this.email = email;
            this.name = name;
        }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}


