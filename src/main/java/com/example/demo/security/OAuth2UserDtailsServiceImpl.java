package com.example.demo.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.demo.domain.RoleType;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class OAuth2UserDtailsServiceImpl extends DefaultOAuth2UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Value("${google.default.password}")
	private String googlePassword;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		//엑세스 토큰이 포함된 userRequest객체를 이용해서
		//loadUser메서드를 호출하면 구글에서 사용자 정보를 받아옴
		OAuth2User oAuth2User = super.loadUser(userRequest);
		String id = oAuth2User.getAttribute("sub");
		String email = oAuth2User.getAttribute("email");
		String username = email +"_"+id;
		String password = googlePassword;
		
		User findUser = userRepository.findByUsername(username).orElseGet(()->{
				return new User();
						});
		
		if(findUser.getUsername()==null) {
			findUser.setUsername(username);
			findUser.setPassword(passwordEncoder.encode(password));
			findUser.setEmail(email);
			findUser.setRole(RoleType.USER);
			
			userRepository.save(findUser);
		}
		return new UserDetailsImpl(findUser,oAuth2User.getAttributes());
	}
	
	
}
