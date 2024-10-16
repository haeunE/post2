package com.example.demo.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Post;


public interface PostRepository extends JpaRepository<Post, Integer>{

//	List<Post> findByTitleContaining(String keyword);
	Page<Post> findByTitleContaining(String keyword,Pageable pageable);
}
