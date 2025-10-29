package com.example.demo.domain.post.dto.response;

import com.example.demo.domain.post.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String contents;

    // post class를 인자로 가지는 생성자
    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }
}