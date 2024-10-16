package com.example.demo.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //테이블 형태로 사용할 것임을 명시
@Table(name = "users") //테이블 명 설정
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//자동으로 시퀀스 설정(일렬번호 매김)
	private int id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String username;
	
	@Column(length = 100)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	//enum이라는 테이블의 데이터 타입은 없기 때문에 따로 타입 설정
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp //자동으로 sysdate가 들어가지도록
	private Timestamp createDate;
}
