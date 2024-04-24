package com.roulette.roulette.code.controller;


import com.roulette.roulette.code.request.CodeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/code")
public class CodeController {
    private final

    @PostMapping
    public void save_code(@RequestBody CodeRequest codeRequest){

    }


}
