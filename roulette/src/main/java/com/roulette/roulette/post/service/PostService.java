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

    @Autowired
    private PostDtoService postDtoService;

    public Page<PostListDto> getRecentPosts(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createTime").descending());
        Page<Post> posts = postRepository.findAll(pageable);

        return posts.map(postDtoService::convertToPostListDto);
        // 이 부분에 대한 설명 필요.

    }

    public Optional<PostDto> getPostById(Long postId){
        Optional<Post> optionalPost  = postRepository.findById(postId); // 포스트가 없을수도 있기 때문에
        return optionalPost.map(postDtoService::convertToPostDto);
    }

    public void setPostChoiceComplete(Long postId) {
        int updatedCount = postRepository.setPostChoiceTrue(postId);
        if (updatedCount == 0) {
            // 업데이트가 발생하지 않았을 경우, 게시글이 존재하지 않는 것일 수 있음
            throw new RuntimeException("No Post found with id: " + postId);
        }
    }

}
