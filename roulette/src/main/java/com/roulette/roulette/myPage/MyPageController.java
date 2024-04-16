package com.roulette.roulette.myPage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    //마이페이지 이동

    @GetMapping("/{member_id}")
    @ResponseBody
    public Map<String, Integer> goMyPage(@PathVariable Long memberId){
        Map<String, Integer> response = new HashMap<>();
        response.put("code", 200);
        System.out.println("dfsdsfdssd");
        return response;
    }

    // 내정보 조회하기
    @GetMapping("/member/{member_id}")
    public ResponseEntity<MemberDTO> getAllMembers(@PathVariable Long memberId) {

        MemberDTO memberDTO = myPageService.getMemberDTO(memberId);
        if (memberDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        System.out.println("dfsdsfdssd");
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    // 내 질문 목록 리스트에서 email포함 해서 DTO만들기
    @GetMapping("/list/{member_id}")
    public ResponseEntity<MyPageDTO> getMyPost(@PathVariable Long memberId){
        MyPageDTO myPageDTO = myPageService.getMyPageData(memberId);
        if (myPageDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(myPageDTO, HttpStatus.OK);
    }

    // 내가 저장한 코드 목록보기
    @GetMapping("/code/{member_id}")
    public ResponseEntity<MyCodeDTO> getMyCode(@PathVariable Long memberId){
        MyCodeDTO myCodeDTO = myPageService.getMyCodeData(memberId);
        if (myCodeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(myCodeDTO, HttpStatus.OK);
    }
}
