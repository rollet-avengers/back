package com.roulette.roulette.post.service;

import com.roulette.roulette.domain.Image;
import com.roulette.roulette.domain.Post;
import com.roulette.roulette.post.dto.PostDto;
import com.roulette.roulette.post.repository.ImageRepository;
import com.roulette.roulette.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ImageRepository imageRepository;

    public Page<PostDto> getRecentPosts(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(this::convertToDto);
        // 이 부분에 대한 설명 필요.


    }

    private PostDto convertToDto(Post post){
        String imgSrc = null;
        Optional<Image> optionalImage = imageRepository.findByPostImg_Post(post);

        if (optionalImage.isPresent()) {
            imgSrc = optionalImage.get().getImgUrl();  // 이미지 URL을 imgSrc 변수에 할당
        }

        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getCreateTime().toString(),
                imgSrc
        );
    }

}
