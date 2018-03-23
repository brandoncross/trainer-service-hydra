package com.revature.hydra.trainer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.hydra.trainer.data.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
		
	public User makeUser(User user) {
		return userRepo.save(user);
	}
	
}
