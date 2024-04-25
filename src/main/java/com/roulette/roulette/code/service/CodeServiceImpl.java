package com.roulette.roulette.code.service;

import com.roulette.roulette.code.codeTranslator.CodeTranslator;
import com.roulette.roulette.code.repository.CodeRepository;
import com.roulette.roulette.dto.mypage.CodeDTO;
import com.roulette.roulette.dto.mypage.SaveCodeDTO;
import com.roulette.roulette.entity.Code;
import com.roulette.roulette.entity.Member;
import com.roulette.roulette.entity.Reply;
import com.roulette.roulette.myPage.MyPageService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CodeServiceImpl implements CodeService {


    private final CodeRepository codeRepository;
    private final MyPageService myPageService;

    private final CodeTranslator codeTranslator;


    // 코드 저장
    @Override
    public void insertReplyCode(String html, String css, String js, Reply reply, Member member) {

        String[]  fileUrls = codeTranslator.saveCodeTranslator(html,css,js);

        // Code 객체로 만든후 repository에 저장
        Code code = Code.builder()
                .htmlCodeUrl(fileUrls[0])
                .cssCodeUrl(fileUrls[1])
                .jsCodeUrl(fileUrls[2])
                .reply(reply)
                .build();

        reply.add(code);

        SaveCodeDTO saveCodeDTO = SaveCodeDTO.builder()
                .code(code)
                .member(member)
                .build();

        myPageService.insert(saveCodeDTO);
        codeRepository.save(code);


    }

    @Override
    public void insertCode(String html, String css, String js, Member member) {
        // 경로 지정
        // 파일 이름 random 생성
        String[]  fileUrls = codeTranslator.saveCodeTranslator(html,css,js);

        // Code 객체로 만든후 repository에 저장
        Code code = Code.builder()
                .htmlCodeUrl(fileUrls[0])
                .cssCodeUrl(fileUrls[1])
                .jsCodeUrl(fileUrls[2])
                .build();


        SaveCodeDTO saveCodeDTO = SaveCodeDTO.builder()
                .code(code)
                .member(member)
                .build();

        myPageService.insert(saveCodeDTO);
        codeRepository.save(code);

    }

    @Override
    public String[] selectCodeById(Long id) {
        Code code = codeRepository.findById(id).get();
        String filePath = "uploads/code";

        String[] str = {"","",""};

        File htmlFile = new File(filePath,code.getHtmlCodeUrl());
        File cssFile = new File(filePath,code.getCssCodeUrl());
        File jsFile = new File(filePath,code.getJsCodeUrl());

        BufferedReader html;
        BufferedReader css;
        BufferedReader js;

        try{
            FileReader htmlReader = new FileReader(htmlFile);
            FileReader cssReader = new FileReader(cssFile);
            FileReader jsReader = new FileReader(jsFile);

            html = new BufferedReader(htmlReader);
            css = new BufferedReader(cssReader);
            js = new BufferedReader(jsReader);

            String line = "";
            while ((line = html.readLine()) != null){
                str[0] += line+"\n";
            }
            while ((line = css.readLine()) != null){
                str[1] += line+"\n";
            }
            while ((line = js.readLine()) != null){
                str[2] += line+"\n";
            }
        } catch (IOException e) {
            System.err.println("Unable to read the file: " + e.getMessage());
            return null;  // 또는 적절한 예외 처리
        }
        log.info("실행");



        return str;
    }
}
