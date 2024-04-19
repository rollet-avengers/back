package com.roulette.roulette.myPage;


import com.roulette.roulette.dto.mypage.*;
import com.roulette.roulette.entity.Code;
import com.roulette.roulette.entity.Member;
import com.roulette.roulette.entity.Post;
import com.roulette.roulette.dto.mypage.*;
import com.roulette.roulette.myPage.myRepository.MyCodeRepository;
import com.roulette.roulette.myPage.myRepository.MyMemberRepository;
import com.roulette.roulette.myPage.myRepository.MyPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface MyPageService {
    MemberDTO getMemberDTO(Long memberId);

    MyPageDTO getMyPageData(Long memberId);

    MyCodeDTO getMyCodeData(Long memberId);

}
