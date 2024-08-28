package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // 설정과 관련됨
@EnableWebSecurity // 시큐리티와 관련됨
public class SecurityConfig {
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.httpBasic(basic -> basic.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize ->
					authorize
					.requestMatchers("/member").authenticated() // /member 요청이 들어왔을때 인증된 사람만 올 수 있게
					.requestMatchers("/admin").hasRole("ADMIN") // 권한이 ROLE_ADMIN인 경우만 들어올 수 있음(ROLE) 자동 인식 기능 
					.anyRequest().permitAll() // 권한 풀기
						)
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		
	}

}
