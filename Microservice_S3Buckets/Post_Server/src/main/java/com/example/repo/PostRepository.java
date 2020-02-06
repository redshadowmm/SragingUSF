package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modle.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

	
}
