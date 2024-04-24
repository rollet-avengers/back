package com.roulette.roulette.myPage;

import com.roulette.roulette.dto.mypage.*;
import com.roulette.roulette.entity.*;
import com.roulette.roulette.myPage.myRepository.*;
import com.roulette.roulette.myPage.myRepository.MyReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private  final MyMemberRepository myMemberRepository;
    private  final MyPostRepository myPostRepository;
    private  final MyReplyRepository myReplyRepository;
    private final SaveCodeRepository saveCodeRepository;


    //내정보 조회하기
    public MemberDTO getMemberDTO(Long member_id){
        Member member =  myMemberRepository.findById(member_id).orElse(null);
        if (member == null)
            return null;
        return new MemberDTO(member.getName(), member.getEmail());
    }

    //내가한 질문들 받아오기
    public MyPageDTO getMyPageData(Long member_id) {
        MyPageDTO myPageDTO = new MyPageDTO();

        // 해당 memberId로 회원의 이메일을 가져와 설정
        Member member = myMemberRepository.findById(member_id).orElse(null);
        String email;
        if (member != null)
            email = member.getEmail();
        else
            email = "No email";

        // 해당 memberId로 회원이 작성한 모든 질문을 가져와 설정
        List<Post> postList = myPostRepository.findAllByMemberId(member_id);
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            PostDTO postDTO = PostDTO.builder()
                    .postId(post.getPostId())
                    .title(post.getTitle())
                    .createdTime(post.getCreateTime())
                    .imgSrc("/uploads/img" + post.getPostId())  // 연수님 참고
                    .build();
            postDTOList.add(postDTO);
        }
        // MyPageDTO 객체를 생성하여 반환
        return MyPageDTO.builder()
                .email(email)
                .postList(postDTOList)
                .memberId(member_id)
                .build();
    }

    //채택 버튼 누르면 savCode에 코드가 저장된다.

    //selectReplyById()
    //내가 올린 코드 불러오기
    public List<SaveCodeDTO> getMyCodeData(Long member_id){
        // 해당 memberId로 회원의 코드 URL과 생성 시간을 가져와 설정
        List<SaveCode> saveCodes = saveCodeRepository.findAllByMemberId(member_id);

        List<SaveCodeDTO> saveCodeDTOS = new ArrayList<>();
        for (SaveCode saveCode : saveCodes) {
            SaveCodeDTO saveCodeDTO = SaveCodeDTO.builder()
                    .code(saveCode.getCode())
                    .member(saveCode.getMember())
                    .saveCodeId(saveCode.getSaveCodeId())
                    .build();
            saveCodeDTOS.add(saveCodeDTO);
        }
        return saveCodeDTOS;
    }

    //채택버튼을 눌렀을 떄 saveCode가 만들어져서 테이블이 만들어지는 코드
    public void insert(SaveCodeDTO saveCodeDTO){
        SaveCode saveCode = SaveCode.builder()
                .code(saveCodeDTO.getCode())
                .member(saveCodeDTO.getMember())
                .saveCodeId(saveCodeDTO.getSaveCodeId())
                .build();
        saveCodeRepository.save(saveCode);
    }
}
