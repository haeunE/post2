package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.example.demo.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

//다양한 유저의 정보를 담는 객체
public class UserDetailsImpl implements UserDetails, OAuth2User{
	
	private static final long serialVersionUID=1L;
	private User user;
	
	//google에서 보내준 유저 정보저장할 컬렉션
	private Map<String, Object> attributes;
	
	//기본, 카카오 로그인 시 사용하는 생성자
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	//OAuth2를 이용해서 로그인할 경우 사용할 생성자
	public UserDetailsImpl(User user, Map<String, Object>attributes) {
		this.user = user;
		this.attributes=attributes;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> roleList = new ArrayList<>();
		roleList.add(()->{
			return "ROLE_" + user.getRole();
			
		});
		return roleList;
	}

	@Override
	public String getPassword() {
		return user.getPassword();//"{noop}"+ 암호화 안해서 저장할 때
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	//만료된 계정인지 리턴시켜ㅜㅈ는 메서드(만료안됨:true)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	//계정이 잠겼는지 리턴시켜주는 메서드(안잠김:true)
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	//자격증명 만료딘건지 리턴
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	//계정 비활성화 여부를 리턴
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		
		return attributes;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
