package com.roulette.roulette.post.repository;

import com.roulette.roulette.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    Page<Post> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.choice = TRUE WHERE p.postId = :postId")
    int setPostChoiceTrue(Long postId);
}
