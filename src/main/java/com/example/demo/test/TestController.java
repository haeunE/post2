package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.UserDTO;




@Controller
public class TestController {
	@GetMapping("/jointest")
	public String test() {
		return "test/join";
	}
	
	@PostMapping("/test/join")
	public String join(@Valid UserDTO userDTO, BindingResult bindingResult, Model model) {
		// 유효성 검사 결과에 따라서 회원가입 처리를 할 건지, 못하게 막을건지
		if(bindingResult.hasErrors()) {//유효성 검사에 에러가 있냐 없냐를 리턴
			//입력한 게 문제가 있으므로 오류메세지를 담아서 보내줌
			//오류메세지를 담아줄 컬렉션 생성
			List<String> errorMsg = new ArrayList<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMsg.add(error.getDefaultMessage());
			}
			model.addAttribute("errorMsg", errorMsg);
			//회원가입 실패해도 기존입력 내용이 남아있어야 하므로 모델에 저장
			model.addAttribute("userDTO",userDTO);
			
			//회원가입 실패했으니까 다시 회원가입 페이지로 넘어가게 리턴시킴
			return "test/join";
		}else {
//			회원가입처리
			return "redirect:/";
			
		}
		
	}
	
	
}
