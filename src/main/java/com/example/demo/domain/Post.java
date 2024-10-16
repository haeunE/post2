package com.example.demo.domain;



import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	private int cnt;
	
	@ManyToOne(fetch = FetchType.EAGER) //1:N 의 N , fetch 언제 가져올지 정하기(EAGER: 바로, LAZY : 필요할때)
	@JoinColumn(name = "userid")//외래키 설정 
	private User user;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)//mappedBy 주 테이블을 지정
	@OrderBy("id desc")
	private List<Reply> replyList;
	
}
