package com.roulette.roulette.myPage;

import com.roulette.roulette.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyMemberRepository extends JpaRepository<Member, Long> {
}

