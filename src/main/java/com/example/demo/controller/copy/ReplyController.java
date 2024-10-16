package com.example.demo.controller.copy;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Reply;
import com.example.demo.domain.ResponseDTO;
import com.example.demo.domain.User;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	@Autowired
	private ReplyRepository replyRepository;

	@PostMapping("/reply/{postId}")
	@ResponseBody
	public ResponseDTO<?> insertReply(@PathVariable int postId, @RequestBody Reply reply,HttpSession session) {
		User user = (User)session.getAttribute("principal");
		
		replyService.insertReply(postId, reply, user);
		
		return new ResponseDTO<>(HttpStatus.OK.value(),postId + "번 게시물 댓글 등록 완료");
		
	}
	
	@DeleteMapping("/reply/{replyId}")
	@ResponseBody
	public ResponseDTO<?> deleteReply(@PathVariable int replyId) {
		replyService.deleteReply(replyId);
		return new ResponseDTO<>(HttpStatus.OK.value(),replyId+"번 댓글 삭제 완료");
	}
}
