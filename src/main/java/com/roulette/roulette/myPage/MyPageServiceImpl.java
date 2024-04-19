package com.roulette.roulette.myPage;

import com.roulette.roulette.dto.mypage.*;
import com.roulette.roulette.entity.Code;
import com.roulette.roulette.entity.Member;
import com.roulette.roulette.entity.Post;
import com.roulette.roulette.myPage.myRepository.MyCodeRepository;
import com.roulette.roulette.myPage.myRepository.MyMemberRepository;
import com.roulette.roulette.myPage.myRepository.MyPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {
    private  final MyMemberRepository myMemberRepository;
    private  final MyPostRepository myPostRepository;
    private  final MyCodeRepository myCodeRepository;


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
                    .imgSrc("127.0.0.1/img/img" + post.getPostId())
                    .build();
            postDTOList.add(postDTO);
        }
        // MyPageDTO 객체를 생성하여 반환
        return MyPageDTO.builder()
                .email(email)
                .postList(postDTOList)
                .build();
    }


    //내가 올린 코드 불러오기
    public MyCodeDTO getMyCodeData(Long member_id){
        MyCodeDTO myCodeDTO = new MyCodeDTO();

//        // 해당 memberId로 회원의 코드 URL과 생성 시간을 가져와 설정
        List<Code> codeList = myCodeRepository.findAllByMemberId(member_id);

        // 해당 memberId로 회원이 작성한 모든 code를 가져와 설정
        List<CodeDTO> codeDTOList = new ArrayList<>();
        for (Code code : codeList) {
            CodeDTO codeDTO = CodeDTO.builder()
                    .codeId(code.getCodeId())
                    .codeName(code.getCodeName())
                    .codeUrl(code.getCodeUrl())
                    .createTime(code.getCreateTime())
                    .build();
            codeDTOList.add(codeDTO);
        }

        return MyCodeDTO.builder()
                .codeList(codeDTOList)
                .build();
    }

}
