package com.roulette.roulette.post.service;

import com.roulette.roulette.domain.Image;
import com.roulette.roulette.domain.Post;
import com.roulette.roulette.post.dto.PostDto;
import com.roulette.roulette.post.dto.PostListDto;
import com.roulette.roulette.post.repository.ImageRepository;
import com.roulette.roulette.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ImageRepository imageRepository;

    public Page<PostListDto> getRecentPosts(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(this::convertToPostListDto);
        // 이 부분에 대한 설명 필요.

    }

    public Optional<PostDto> getPostById(Long postId){
        Optional<Post> optionalPost  = postRepository.findById(postId); // 포스트가 없을수도 있기 때문에

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            return Optional.ofNullable(convertToPostDto(post));
        }

        return Optional.empty();
    }

    public PostDto convertToPostDto(Post post){

        String imgSrc = null;
        Optional<Image> optionalImage = imageRepository.findByPostImg_Post(post);

        if (optionalImage.isPresent()) {
            imgSrc = optionalImage.get().getImgUrl();
        }

        PostDto postDto = new PostDto(
                post.getPostId(),
                post.getMember().getMemberId(),
                post.getContents(),
                imgSrc
        );

        return postDto;

    }

    private PostListDto convertToPostListDto(Post post){
        String imgSrc = null;
        Optional<Image> optionalImage = imageRepository.findByPostImg_Post(post);

        if (optionalImage.isPresent()) {
            imgSrc = optionalImage.get().getImgUrl();  // 이미지 URL을 imgSrc 변수에 할당
        }

        return new PostListDto(
                post.getPostId(),
                post.getTitle(),
                post.getCreateTime().toString(),
                imgSrc
        );
    }

}
