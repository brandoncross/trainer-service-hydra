package com.revature.hydra.trainer.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.hydra.trainer.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		log.info("Saving trainer: " + user);
		User persisted = userService.makeUser(user);
		return new ResponseEntity<>(persisted, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> updateUser(@Valid @RequestBody User user) {
		log.info("Updating user " + user);
		userService.update(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@GetMapping(value = "/email/{email:.+}/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
		log.info(email);
		log.info("Finding user by email of " + email);
		User user = userService.findUserByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> makeInactive(@RequestBody User user) {
		log.info("Updating user: " + user);
		user.setRole(0);
		userService.update(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("roles")
	public ResponseEntity<List<Integer>> getAllUserRoles() {
		log.info("Fetching all user roles");
		List<Integer> roles = userService.getAllRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity getAllUsers() {
		log.info("Viewing all users");
		List<User> userList = userService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);

	}

	@GetMapping("id/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Integer id) {
		log.info("Fetching user based on id.");
		User user = userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("name/{firstName}/{lastName}")
	public ResponseEntity<User> findByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		String name = firstName + " " + lastName;
		User user = userService.findByName(name);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
