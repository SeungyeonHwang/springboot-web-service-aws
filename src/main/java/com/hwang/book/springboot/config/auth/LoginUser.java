package com.hwang.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션이 생성될 수 있는 위치 지정
//PARAMETER -> 파라미터로 선언된 객체에서만 사용가능
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
//@interface -> 이 파일을 어노테이션 클래스로 지정
//LoginUser라는 어노테이션 생성과 동일
public @interface LoginUser {
}
