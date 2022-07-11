package com.lim.book.springboot.web.dto;

import com.lim.book.springboot.domain.post.Posts;
import com.lim.book.springboot.domain.post.PostsRepository;
import lombok.Getter;

import javax.persistence.Id;

@Getter
public class PostsResponseDto {

    private Long Id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts Entity){
        this.Id= Entity.getId();
        this.content = Entity.getContent();
        this.title = Entity.getTitle();
        this.author = Entity.getAuthor();
    }


}
