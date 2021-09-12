package com.hwang.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //Jpa Auditing 활성화, @WebMvcTest 는 일반적인 @Configuration 스캔하지 않는다
public class JpaConfig {}
