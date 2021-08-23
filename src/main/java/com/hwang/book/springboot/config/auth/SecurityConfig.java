package com.hwang.book.springboot.config.auth;

import com.hwang.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity  //Spring Security 설정 활성화
public class SecurityConfig extends
        WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests() //URL별 권한 관리를 설정, authorizeRequests선언 되어야지만 antMatchers 옵션 사용 가능
                    .antMatchers("/", "/css/**", "/images/**", "js/**", "/h2-console/**").permitAll()
                    //권한 관리 대상 지정, URL,HTTP 메소드 별 관리, '/'등 지정된 URL은 permitAll 옵션으로 전체 열람 권한 가짐
                    //아래 URL은 USER권한을 가진 사람만 열람 가능
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() //설정 값 이외의 URL, authenticated(): 인증된 사용자에게만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그 아웃 기능에 대한 설정 엔드 포인트, 로그아우 성공시 -> / 주소 이동
                .and()
                    .oauth2Login() //OAuth2 로그인 설정 엔드포인트
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보 가져옴
                            //소셜 로그인 성공시, 후속 조치 진행할 UserService 인터페이스 구현체 등록
                            //리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시 가능
                            .userService(customOAuth2UserService);
    }
}
