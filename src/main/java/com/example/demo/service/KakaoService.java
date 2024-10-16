package com.example.demo.service;






import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.demo.domain.RoleType;
import com.example.demo.domain.User;
import com.google.gson.Gson;

@Service
public class KakaoService {
	
	@Value("${kakao.default.password}")
	private String kakaoPassword;

	public String getAccessToken(String code) {
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "2b9a3010369c5138ce0adef97b47c746");
		body.add("redirect_uri", "http://localhost:8888/oauth/kakao");
		body.add("code", code);
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body,header);
		
		System.out.println(body);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(
					"https://kauth.kakao.com/oauth/token", //요청 url
					HttpMethod.POST,  //요청메서드
					requestEntity,	//요청객체
					String.class //응답받을 데이터 타입
				);
		
		String jsonData = responseEntity.getBody();
		Gson gson =  new Gson();
		Map<?, ?> data = gson.fromJson(jsonData,Map.class);
		
		return (String)data.get("access_token");
	}
	public User getUserInfo(String accessToken) {
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer " + accessToken);
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(header);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST,
				requestEntity,
				String.class
				);
		
		String jsonData = responseEntity.getBody();
		Gson gson = new Gson();
		Map<?, ?> data = gson.fromJson(jsonData, Map.class);
		//응답데이터에서 닉네임을 추출하기위한 처리
		Map<?, ?> properties = (Map<?, ?>)data.get("properties");
		String nickname = (String)properties.get("nickname");
		
		
		//응답데이터에서 이메일을 추출하기 위한 처리
		Map<?, ?> account = (Map<?, ?>) data.get("kakao_account");
		String email = (String)account.get("email");
		
		System.out.println(nickname +"\n"+ email);
		
		User user = new User();
		user.setUsername(nickname);
		user.setEmail(email);
		user.setPassword(kakaoPassword);
		user.setRole(RoleType.USER);
		
		return user;
	}
}
