package com.example.demo.controller.copy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/html")
	public String html() {
		System.out.println("html 요청받음");
		return "redirect:hello.html";
	}
	
	@GetMapping("/text")
	@ResponseBody
	public String text() {
		return "hello text";
	}
	@GetMapping("/img")
	public String img() {
		System.out.println("html 요청받음");
		return "redirect:img/pepe.jpg";
	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		model.addAttribute("name", "홍길동");
		return "hello";
	}
}
