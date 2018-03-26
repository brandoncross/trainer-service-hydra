package com.revature.hydra.trainer.service;

import java.util.List;

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

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User update(User user) {
		return userRepo.save(user);

	}

	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public List<Integer> getAllRoles() {
		return userRepo.findAllUserRoles();
	}

	public User findUserById(Integer id) {
		return userRepo.findOne(id);
	}

	public User findByName(String firstName, String lastName) {
		return userRepo.findUserByFirstNameAndLastName(firstName, lastName);
	}

}
