package com.hwang.book.springboot.web.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//시작 화면(Mustache)
@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // -> templates/index.mustache 전환, View Resolver 가 처리(타입, 값 지정 하는 관리자)
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";    //posts-save.mustache 호출
    }
}
