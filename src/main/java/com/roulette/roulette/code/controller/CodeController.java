package com.roulette.roulette.code.controller;

import com.roulette.roulette.code.request.CodeRequest;
import com.roulette.roulette.code.response.CodeResponse;
import com.roulette.roulette.code.service.CodeService;
import com.roulette.roulette.dto.code.CodeDTO;
import com.roulette.roulette.entity.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/code")
public class CodeController {
    private final CodeService codeService;


    // "/code"
    // 코드 파일 업로드
    @PostMapping
    public ResponseEntity<String> codeFileUpload(@RequestBody @Valid CodeRequest codeRequest) {
        MultipartFile file = codeRequest.getCode();

        String directoryPath = "uploads/code/";
        String fileName = file.getOriginalFilename();

        try {
            // 파일 처리 로직, 예를 들어 파일을 서버에 저장할 수 있습니다.
            file.transferTo(new File(directoryPath + fileName));

            CodeDTO codeDTO = CodeDTO.builder()
                    .codeUrl(directoryPath + fileName)
                    .member(new Member("아무개","aaa@naver.com"))
                    .confirm(false)
                    .build();

            codeService.insertCode(codeDTO);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("error");
        }


    }

    // "/code/{id}"
    // 코드 파일 가져오기
    @GetMapping(value = "/{id}")
    public ResponseEntity<Map> downloadCodeFile(@PathVariable Long id){
        Map<CodeResponse,String> result = new HashMap<>();
        CodeDTO codeDTO = codeService.getCodeFile(id).get();
        File file = new File(codeDTO.getCodeUrl());

        CodeResponse codeResponse = CodeResponse.builder()
//                .member(codeDTO.getMember())
                .code(file)
                .build();

        result.put(codeResponse, "success");

        return ResponseEntity.ok(result);
    }

}
