package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.modle.Post;
import com.example.modle.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	List<Post> findByPoster(User poster);
	
}
