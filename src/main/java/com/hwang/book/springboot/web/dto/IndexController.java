package com.hwang.book.springboot.web.dto;

import com.hwang.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//시작 화면(Mustache)
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {  //객체 저장, posts -> index.mustache전달
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // -> templates/index.mustache 전환, View Resolver 가 처리(타입, 값 지정 하는 관리자)
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";    //posts-save.mustache 호출
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
