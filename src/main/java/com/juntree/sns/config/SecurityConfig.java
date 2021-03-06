package com.juntree.sns.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IoC
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // super 삭제시 -> 기존 시큐리티가 가지고 있는 기능이 다 비활성화 됨

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**")
            .authenticated()
            .anyRequest().permitAll()
            .and()
            .formLogin()
            .loginPage("/auth/signin")
            .defaultSuccessUrl("/");

    }
}
