package com.roulette.roulette.code.service;

import com.roulette.roulette.dto.code.CodeDTO;

import java.util.Optional;

public interface CodeService {
    public void insertCode(CodeDTO codeDTO);

    public Optional<CodeDTO> getCodeFile(Long id);
}
