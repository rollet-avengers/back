package com.roulette.roulette.code.controller;

import com.roulette.roulette.code.request.CodeRequest;
import com.roulette.roulette.code.response.CodeResponse;
import com.roulette.roulette.code.service.CodeService;
import com.roulette.roulette.dto.code.CodeDTO;
import com.roulette.roulette.entity.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/code")
public class CodeController {

}
