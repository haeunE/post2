package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.domain.Reply;
import com.example.demo.domain.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.ReplyRepository;

@Service
public class ReplyService {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	
	public void insertReply(int postId, Reply reply, User user) {
		//postId 를 이용해서 댓글이 달린 게시물 정보 추출
		
		Post post = postRepository.findById(postId).get();
		reply.setUser(user);
		reply.setPost(post);
		
		replyRepository.save(reply);
		
	}
	public void deleteReply(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
