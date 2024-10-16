package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.RoleType;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //의존성 주입
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional // 아래 두 코드 중 하나라도 실패하면 완료처리되면 안되므로 해당 코드로 완벽하게 실행될때만 commit 되도록 한다. 
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	//username으로 검색한 결과가 있으면 해당 객체를 리턴 없으면 빈객체를 리턴
	public User getUser(String username) {
		User findUser = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		return findUser;
		
	}
}
