package com.roulette.roulette.code.codeTranslator;

import com.roulette.roulette.entity.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
@Component
@Slf4j
public class CodeTranslatorImpl implements CodeTranslator {

    private String codePath ="uploads/code/";

    // text파일 업로드를 위한 로직
    @Override
    public String[] saveCodeTranslator(String html, String css, String js) {
        // 경로 지정
        // 파일 이름 random 생성
        String htmlFile = UUID.randomUUID().toString();
        String cssFile = UUID.randomUUID().toString();
        String jsFile = UUID.randomUUID().toString();


        // text파일 디렉토리에 저장
        saveFile(html, htmlFile);
        saveFile(html, cssFile);
        saveFile(html, jsFile);


        String[] fileNames = new String[3];
        fileNames[0] = htmlFile;
        fileNames[1] = cssFile;
        fileNames[2] = jsFile;



        return fileNames;
    }
    // text 파일 디렉토리에 저장
    public void saveFile(String code,String fileName){
        try {
            BufferedWriter codeWriter = new BufferedWriter(new FileWriter(codePath+ fileName));

            codeWriter.write(code);

            codeWriter.close();

        } catch (IOException e) {
            log.info("Error occurred while writing to file: " + e.getMessage());
            // 로깅 라이브러리로 로그 기록을 남기거나, 적절한 예외 처리를 수행할 수 있습니다.
        }
    }


    // text 파일 다운로드를 위한 로직

}
