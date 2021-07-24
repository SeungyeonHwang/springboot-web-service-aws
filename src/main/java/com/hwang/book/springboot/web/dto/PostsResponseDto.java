package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime modifiedDate;

    //Entity필드 중 일부만 사용하므로 생성자로 Entity를 받아 필드에 넣어준다
    //굳이 모든 필드를 가진 생성자가 필요한 건 아니라서, Entity 받아서 처리
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
