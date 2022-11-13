package com.cbu.backend.member.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity      //Spring Security 설정할 클래스라고 정의
@RequiredArgsConstructor
public class SecurityConfig {

//    private final OAuthMemberService oAuthUserService;
//    private final OAuth2SuccessHandler successHandler;
//    private final CorsConfig corsConfig;
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                //이거 지원하나? -> 인가 관련 설정하기
                .antMatchers("/**").permitAll()
                //로그인 하지 않고 모든 권한을 가짐
                .anyRequest().authenticated()
                //그 외 모든 요청은 인증된 사용자만 접근 가능
                .and()
                .formLogin().disable()
                //폼 로그인 형태 x
                .oauth2Login()
                //oauth2 로그인 설정
                    .authorizationEndpoint()
                    .baseUri("/api/oauth2")
                    // 이 부분에서 oauth2로그인 요청을 함
                    .and()
//                    .successHandler(successHandler)
                    .userInfoEndpoint()
//                    .userService(oAuthUserService)
                    //소셜로그인 userinfo의 응답을 처리하기 위한 설정 oauth2로그인에 성공하면 userservice 설정을 진행하겠다.
                    .and()
                .and()
//                cors  설정 구성
//                .and()
                .csrf().disable()
                //csrf 토큰해제
                .build();

    }

}
