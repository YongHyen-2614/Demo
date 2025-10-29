package com.example.demo.domain.post.controller;

import com.example.demo.domain.post.dto.request.PostRequestDto;
import com.example.demo.domain.post.dto.response.PostResponseDto;
import com.example.demo.domain.post.entity.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final Map<Long, Post> postList = new HashMap<>();

    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto) {
        // ID 번호 생성
        Long postId = postList.isEmpty() ? 1 : Collections.max(postList.keySet()) + 1;

        // 새post 생성
        Post post = new Post(
                postId,
                requestDto.getTitle(),
                requestDto.getContents());

        //inmemory에 저장
        postList.put(postId, post);

        //응답
        return new PostResponseDto(post);
    }
}
