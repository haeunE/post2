package com.example.demo.controller.copy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.User;
import com.example.demo.service.KakaoService;
import com.example.demo.service.UserService;


@Controller
public class kakaoController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private KakaoService kakaoService;
	
	@Value("${kakao.default.password}")
	private String kakaoPassword;
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	
	@GetMapping("/oauth/kakao")
	
	public String kakaoCallBack(String code) {
		String accessToken = kakaoService.getAccessToken(code);
		User kakaoUser = kakaoService.getUserInfo(accessToken);
		
		//kakaouser정보가 DB에 있는지 체크
		User findUser = userService.getUser(kakaoUser.getUsername());
		//DB에서 검색한findUser에 내용이 없으면 회원가입 처리
		//내용이 있으면 이미 있는 사람이므로 넘어감 
		if(findUser.getUsername() == null)
			userService.insertUser(kakaoUser);
		
		//로그인 처리
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), kakaoPassword);
		
		Authentication authentication = authenticationManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "redirect:/";
	}
	
	
}
