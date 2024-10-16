package com.example.demo.controller.copy;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.PageDTO;
import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;


@Controller
public class BoardController {
	@Autowired
	PostRepository postRepository;
	@Autowired
	PostService postService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}
