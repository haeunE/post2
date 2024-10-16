package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
