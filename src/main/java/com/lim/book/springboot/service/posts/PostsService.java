package com.lim.book.springboot.service.posts;

import com.lim.book.springboot.domain.post.Posts;
import com.lim.book.springboot.domain.post.PostsRepository;
import com.lim.book.springboot.web.dto.PostsResponseDto;
import com.lim.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsSaveRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당계시물이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당계시물이 없습니다. id ="+ id));

        return new PostsResponseDto(entity);
    }
}
