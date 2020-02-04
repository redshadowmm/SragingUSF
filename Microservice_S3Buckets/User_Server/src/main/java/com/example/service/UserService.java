package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.modle.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	
	public UserService() {
	}
	
	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User Login(String userName, String password)
	{
		return userRepo.findByUserNameAndPassword(userName, password);
	}
	public User addUser(User user) {
		user.setId(-1);
		return userRepo.save(user);
	}

	public User updateUser(User curUser, User replacementUser) {
		if(userRepo.exists(Example.of(curUser)))
		{
			curUser.setFirstName(replacementUser.getFirstName());
			curUser.setLastName(replacementUser.getLastName());
			curUser.setPassword(replacementUser.getPassword());
			return userRepo.save(curUser);
		}
		return null;
	}
	

}
