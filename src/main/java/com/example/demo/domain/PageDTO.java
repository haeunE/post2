package com.example.demo.domain;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class PageDTO {
	// 페이지 블록에서 시작번호와 끝번호를 저장하는 변수들
	private int startPage;
	private int endPage;
	private boolean prev, next; //이전, 다음 블록 존재 여부를 저장
	
	private Page<Post> page;
	private int totalPages; //전체 페이지 수
	private long totalElements; //전체 레코드 수
	
	public PageDTO(Page<Post> page) {
		this.page = page;
		this.totalPages = page.getTotalPages();
		this.totalElements = page.getTotalElements();
		//현재 페이지
		int currentPage = page.getNumber()+1;
		
		this.endPage = (int)Math.ceil(currentPage/3.0) *3; //ceil 은 올림처리 2/3.0=>1*3=3
		this.startPage = endPage-2;
		
		if(totalPages <endPage) {
			endPage = totalPages;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.totalPages;
	}
	
	
}
