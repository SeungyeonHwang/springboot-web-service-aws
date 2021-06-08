package com.hwang.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter     //get method
@RequiredArgsConstructor    //final 선언 된 변수 의존성 주입 받을 수 있음(생성자 주입)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
