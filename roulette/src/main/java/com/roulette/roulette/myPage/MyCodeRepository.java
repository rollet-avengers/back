package com.roulette.roulette.myPage;

import com.roulette.roulette.domain.Code;
import com.roulette.roulette.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyCodeRepository extends JpaRepository<Code, String> {
    @Query("SELECT p FROM Code p WHERE p.member.memberId = :memberId")
    List<Code> findAllByMemberId(Long memberId);

}
