package com.roulette.roulette.post.service;

import com.roulette.roulette.domain.Image;
import com.roulette.roulette.domain.Post;
import com.roulette.roulette.post.dto.PostDto;
import com.roulette.roulette.post.dto.PostListDto;
import com.roulette.roulette.post.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostDtoService {

    @Autowired
    private ImageRepository imageRepository;

    public PostDto convertToPostDto(Post post) {
        String imgSrc = null;
        Optional<Image> optionalImage = imageRepository.findByPostImg_Post(post);
        if (optionalImage.isPresent()) {
            imgSrc = optionalImage.get().getImgUrl();
        }

        return new PostDto(
                post.getPostId(),
                post.getMember().getMemberId(),
                post.getContents(),
                imgSrc
        );
    }

    public PostListDto convertToPostListDto(Post post) {
        String imgSrc = null;
        Optional<Image> optionalImage = imageRepository.findByPostImg_Post(post);
        if (optionalImage.isPresent()) {
            imgSrc = optionalImage.get().getImgUrl();
        }

        return new PostListDto(
                post.getPostId(),
                post.getTitle(),
                post.getCreateTime().toString(),
                imgSrc
        );
    }
}