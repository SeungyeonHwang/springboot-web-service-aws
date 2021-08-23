package com.hwang.book.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)    //테스트 진행할 때, Junit에 내장된 실행자 외에 다른 실행자로 실행, 스프링 부트와 Junit 사이의 연결자
@WebMvcTest(controllers = HelloController.class)
//@Controller, @ControllerAdvice 등 사용 가능, @Service, @Repository 사용 불능
public class HelloControllerTest {

    @Autowired  //Bean 주입
    private MockMvc mvc;    //웹 API 테스트 할때 사용, 스프링 MVC의 시작점, HTTP GET, POST 등의 테스트 가능

    @Test
    public void hello_리턴됨() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))  //MockMVC 통해 /hello 주소로 get 요청
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_리턴됨() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)    //요청 파라미터 설정, String만 허용, 숫자/날짜 등의 데이터도 등록할때는 문자열로 변경해야함
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))    //JSON 응답값을 필드별로 검증할 수있는 메소드, $기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}