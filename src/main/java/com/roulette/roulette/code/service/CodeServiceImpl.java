package com.roulette.roulette.code.service;

import com.roulette.roulette.code.repository.CodeRepository;
import com.roulette.roulette.dto.code.CodeDTO;
import com.roulette.roulette.entity.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepository;
    @Override
    public void insertCode(CodeDTO codeDTO) {

        Code code = Code.builder()
                        .codeUrl(codeDTO.getCodeUrl())
                        .confirm(codeDTO.isConfirm())
                        .member(codeDTO.getMember())
                        .build();

        codeRepository.save(code);
        codeRepository.findOneByMember(1L);
    }

    @Override
    public Optional<CodeDTO> getCodeFile(Long id) {
        Code code = codeRepository.findById(id).get();

        CodeDTO codeDTO = CodeDTO.builder()
                .codeId(code.getCodeId())
                .codeUrl(code.getCodeUrl())
                .member(code.getMember())
                .confirm(code.isConfirm())
                .build();

        return Optional.ofNullable(codeDTO);
    }
}
