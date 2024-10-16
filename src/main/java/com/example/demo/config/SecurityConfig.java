package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
			.antMatchers("/","/auth/**","/js/**","/img/**","/webhars/**","/oauth/**") //로그인 상태가 아니여도 접근 가능한 루트
			.permitAll()
			.anyRequest().authenticated();
		http.csrf().disable();
		http.formLogin().loginPage("/auth/login");
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
		http.oauth2Login();
		return http.build();
	}
	//인증절파 및 진행
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfigrtaion) throws Exception{
		return authenticationConfigrtaion.getAuthenticationManager();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
