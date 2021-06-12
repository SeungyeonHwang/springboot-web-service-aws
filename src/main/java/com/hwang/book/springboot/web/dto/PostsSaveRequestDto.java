package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity와 거의 유사한 형태, Dto 클래스를 추가로 생성
 * 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨
 * Entity 클래스는 데이터 베이스와 맞닿아 있기 때문에 Entity를 기준으로 테이블이 생성되고 스키마가 변경됨
 * 화면 변경은 사소한기능임, Entity 를 변경하는건 너무 큰 변경임
 * Request, Response용 Dto는 View를 위한 클래스라 자주 변경이 필요함(영향 범위가 적음)
 * View Layer와 DB Layer의 구분을 철저히 해주는게 좋다
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
