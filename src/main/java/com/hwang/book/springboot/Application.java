package com.hwang.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing //JPA Auditing 기능 활성화 -> @Entity클래스 필요해서 일단 제거(@WebMvcTest 에서 스캔 되어 오류 발생)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
