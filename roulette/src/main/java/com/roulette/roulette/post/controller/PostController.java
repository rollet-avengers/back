package com.roulette.roulette.post.controller;

import com.roulette.roulette.domain.Post;
import com.roulette.roulette.post.dto.PostDto;
import com.roulette.roulette.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/code/list/{page}")
    public Page<PostDto> getPosts(@PathVariable int page) {
        return postService.getRecentPosts(page, 10);
    }
}
