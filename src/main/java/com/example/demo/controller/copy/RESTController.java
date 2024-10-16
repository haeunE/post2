//package com.example.demo;
//
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//
//@CrossOrigin(origins = "*")
//@RestController //response + controller
//public class RESTController {
//	
//	
//	
////	@GetMapping("/rest")
//	public String get() {
//		return "get 요청 처리";
//	}
//	@PostMapping("/rest")
//	public String post() {
//		
//		return "post 요청 처리";
//	}
//	
//	@PutMapping("/rest")
//	public String put() {
//		return "put 요청 처리";
//	}
//	@DeleteMapping("/rest")
//	public String delete() {
//		return "delete 요청 처리";
//	}
//	
//	
//	
//	@GetMapping("/test")
//	public List<TestVO> getTestVO() {
//		TestVO vo = new TestVO("홍길동","1234");
//		TestVO vo2 = new TestVO("이하은","0401");
//		TestVO vo3 = new TestVO("박지민","0623");
//		List<TestVO> list = new ArrayList<>();
//		list.add(vo);
//		list.add(vo2);
//		list.add(vo3);
//		
//		return list;
//	}
//	//html 에 form 태그로 처리
//	@PostMapping("/test")
//	public String postTest(TestVO vo) {
//		System.out.println(vo.getName());
//		System.out.println(vo.getPw());
//		
//		return "정상처리" ;
//	}
////	json 으로 데이터 전송 *기본생성자가 없으면 안됨
//	@PostMapping("/test2")
//	public String postTest2(@RequestBody TestVO vo) {
//		System.out.println(vo.getName());
//		System.out.println(vo.getPw());
//		
//		return "정상처리" ;
//	}
//	
//	@DeleteMapping("/test/{no}")
//	public String delete(@PathVariable Integer no) {
//		return " delete 요청: "+ no;
//	}
//	
//	@PutMapping("/test")
//	public String put(@RequestParam Integer page) {
//		return "요청한 페이지 번호 : " + page;
//	}
//	
//	@GetMapping("/user")
//	public User getUser() {
//		User user = new User(1, "grace", "1234","grace1004@gamil.com");
//		
//		return user;
//	}
//	
//	@PostMapping("/user")
//	public User postUser(User us) {
//		
//		//TODO: process POST request
//		System.out.println(us.getId());
//		System.out.println(us.getUsername());
//		System.out.println(us.getPassword());
//		System.out.println(us.getEmail());
//		return us;
//	}
//	
//	@PutMapping("/user")
//	public void putUser(@RequestParam int id) {
//		//TODO: process PUT request
//		System.out.println(id);
//	}
//	
//	
//}
//package com;


