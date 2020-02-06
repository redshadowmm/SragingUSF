package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.modle.User;
import com.example.service.UserService;


@RestController
@RequestMapping("/login_service")
public class LoginController {
	
	private UserService userService;
	private RestTemplate restTemp = new RestTemplate();
	
	public LoginController() {
	}
	@Autowired	
	public LoginController(UserService userService) {
		this.userService = userService;
		//this.restTemp= restTemp;
	}

	@GetMapping("/logging_in")
	public User getUser(@RequestBody User user) {
		System.out.println(user);
		return userService.Login(user.getUserName(), user.getPassword());
		
	}

	/**
	 * @author Ian Gillespie
	 * This method will only add a new user it cannot update
	 * This method will break if given a nonunique username
	 * 
	 * @param A user to add to the database
	 * @return The user with the generated id
	 * 
	*/
	@PostMapping("/register_user")
	public User createUser(@RequestBody User user) {
		//send a creation to the other servers
		
		User temp =userService.addUser(user);
		
		restTemp.postForEntity("http://localhost:9054/post-server/userapi/create_user", temp, Boolean.class);
			
		
		return temp;
	}

	/**
	 * @author Ian Gillespie
	 * This method will only deal with the first 2 array list entries
	 * entry 1 being the old data and entry 2 being the new data
	 * 
	 * @param A user to add to the database
	 * @return The user with the generated id
	 * 
	*/
	@PostMapping("/internal_api_update_user")
	public User updateUser(@RequestBody User[] user) {
		//send an update to the other servers
		return userService.updateUser(user[0], user[1]);
	}
	
	
}
