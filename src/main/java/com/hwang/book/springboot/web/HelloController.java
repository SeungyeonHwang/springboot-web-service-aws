package com.hwang.book.springboot.web;

import com.hwang.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON 반환하는 컨트롤러 만들어줌, @ResponseBody 메소드마다 선언했던거 한번에 쓴거라고 이해
public class HelloController {

    @GetMapping("/hello") //HTTP Method Get 요청 받을 수 있는 API 만들어 줌
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,     //RequestParam -> 외부에서 API로 넘긴 파라미터 가져옴
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
