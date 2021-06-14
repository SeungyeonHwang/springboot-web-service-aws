package com.hwang.book.springboot.web;

import com.hwang.book.springboot.service.posts.PostsService;
import com.hwang.book.springboot.web.dto.PostsResponseDto;
import com.hwang.book.springboot.web.dto.PostsSaveRequestDto;
import com.hwang.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {     //Controller -> Service呼び出し
        return postsService.save(requestDto);
    }

    //글 수정
    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //글 조회(id)
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
