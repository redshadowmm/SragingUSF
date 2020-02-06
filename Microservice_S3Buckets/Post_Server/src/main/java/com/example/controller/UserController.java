package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modle.User;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@PostMapping("/create_user")
	public boolean addUser(@RequestBody User user) {
		
		return false;
	}
	
	@PostMapping("/update_user")
	public boolean updateUser(@RequestBody User user) {
		
		return false;
	}
	
}
