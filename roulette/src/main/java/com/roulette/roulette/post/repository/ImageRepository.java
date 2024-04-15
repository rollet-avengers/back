package com.roulette.roulette.post.repository;

import com.roulette.roulette.domain.Image;
import com.roulette.roulette.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByPostImg_Post(Post post);
}
