package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;

@SpringBootTest
class Prec01ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Test
	void contextLoads() {
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		User user = userRepository.findById(14).get();
		System.out.println(user);
		System.out.println(encoder.matches("1234", user.getPassword()));
		
//		User user = userRepository.findById(6).get();
//		
//		for (int i=0; i<100; i++) {
//			Post post = new Post();
//			post.setTitle("임시 게시물 제목:"+i);
//			post.setContent("임시 게시물 내용" + i);
//			post.setUser(user);
//			postRepository.save(post);
//		}
//	
//		//id가 1번인 레코드 삭제
//		userRepository.deleteById(1);
		
		
		//id가 1번인 사람의 이름을 park으로 수정
//		Optional<User> user = userRepository.findById(1);
//		User u = user.get();
//		u.setUsername("park");
//		userRepository.save(u);
		
		
//		String keyword = "on";
//		// 포함이라는 걸로 처리되도록 만능문자가 있어야 함
//		keyword = "%" + keyword +"%";
//		List<User> result = userRepository.findByUsernameLike(keyword);
		//		//username과 password 기준으로 검색
//		User result = userRepository.findByUsernameAndPassword("hong","1234" );
//		System.out.println(result);
//		
		
		//select * from users where id=?
		
		//username을 기준으로 검색한 결과
//		User result = userRepository.findByUsername("hong");
//		System.out.println(result);
		
//		Optional<User> result = userRepository.findById(1);//기본키
//		System.out.println(result.isPresent());
//		if(result.isPresent()) {
//			User u = result.get();
//			System.out.println(u);}
//		else {
//			System.out.println("검색한 결과가 없음");
		
//		List<User> users = userRepository.findAll();
//		System.out.println(users.size());
//		
//		for(User u: users) {
//			System.out.println(u);
		
//		User user = new User();
//		user.setUsername("kim");
//		user.setPassword("1234");
//		user.setEmail("asd@naver.com");
//		user.setRole(RoleType.USER);
//		
//		userRepository.save(user);
	}
}
