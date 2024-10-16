package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.PageDTO;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.PostDTO;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postrepository;
	
	public void insertPost(PostDTO postDTO,User user) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setContent(postDTO.getContent());
		post.setCnt(0);;
		post.setUser(user);
		postrepository.save(post);
		
	}
	@Transactional(readOnly=true)//읽기 전용으만 사용할 것에 대해 예외처리
	public Page<Post> getPostList(Pageable pageable){
		return postrepository.findAll(pageable);
	}
	
	public Post getPost(Integer id) {
		Optional<Post> data = postrepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}else {
			return null;
		}
	}
	
	
	@Transactional
	public void updatePost(Post post) {
		Post findPost = postrepository.findById(post.getId()).get();
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
//		postrepository.save(findPost);
	}
	
	public void deletePost(int id) {
		postrepository.deleteById(id);
	}
	public Page<Post> search(String keyword,Pageable pageable) {
		Page<Post> list =  postrepository.findByTitleContaining(keyword, pageable);
		return list;
	}
	
}
