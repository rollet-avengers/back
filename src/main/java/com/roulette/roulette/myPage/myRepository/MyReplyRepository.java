package com.roulette.roulette.myPage.myRepository;

import com.roulette.roulette.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyReplyRepository extends JpaRepository<Reply, String> {
    @Query("SELECT p FROM Reply p WHERE p.member.memberId = :memberId")
    List<Reply> findAllByMemberId(Long memberId);

}
