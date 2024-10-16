package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

import java.util.Optional;


@Repository //테이블 설정
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String usesrname);
}
