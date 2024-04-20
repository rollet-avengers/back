package com.roulette.roulette.code.repository;

import com.roulette.roulette.entity.Code;

import java.util.Optional;

public class CodeQueryDSLImpl implements CodeQueryDSL {

    @Override
    public Optional<Code> findOneByMember(Long id) {
        return Optional.empty();
    }
}
