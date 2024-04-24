package com.roulette.roulette.myPage;


import com.roulette.roulette.dto.mypage.*;

import java.util.List;

public interface MyPageService {
    MemberDTO getMemberDTO(Long memberId);

    MyPageDTO getMyPageData(Long memberId);

    List<SaveCodeDTO> getMyCodeData(Long memberId);

    public void insert(SaveCodeDTO saveCodeDTO);

}
