package com.roulette.roulette.code.service;

import com.roulette.roulette.dto.code.CodeDTO;
import com.roulette.roulette.entity.Member;
import com.roulette.roulette.entity.Reply;

import java.util.Optional;

public interface CodeService {
    public void insertCode(String html, String css, String js, Reply reply);


}
