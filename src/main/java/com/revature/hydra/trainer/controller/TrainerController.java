package com.revature.hydra.trainer.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.TrainerUser;
import com.revature.beans.User;
import com.revature.hydra.trainer.service.TrainerService;
import com.revature.hydra.trainer.service.UserService;

import com.revature.beans.SimpleTrainer;
import com.revature.beans.Trainer;
import com.revature.beans.TrainerRole;
import com.revature.hydra.trainer.service.TrainerService;

@RestController
@CrossOrigin
@RequestMapping(value = "trainers", produces = MediaType.APPLICATION_JSON_VALUE)
public class TrainerController {

	private static final Logger log = Logger.getLogger(TrainerController.class);

	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		log.info("Saving trainer: " + user);
		User persisted = userService.makeUser(user);
		return new ResponseEntity<>(persisted, HttpStatus.CREATED);
	}
	
	@PostMapping
	public ResponseEntity<TrainerUser> makeTrainer(@RequestBody TrainerUser tu) {
		TrainerUser t = trainerService.newTrainer(tu);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
<<<<<<< HEAD

	/**
	 * Finds a trainer by email. Used for logging in a user with the Salesforce
	 * controller Note: The final "/" is necessary for a web browser to be able to
	 * connect to the controller.
	 *
	 * @param email
	 * @return Trainer
	 */
	@RequestMapping(value = "trainers/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("permitAll")
	public ResponseEntity<SimpleTrainer> findTrainerByEmail(@PathVariable String email) {
		log.trace("Find trainer by email " + email);

		SimpleTrainer trainer = trainerService.findByEmail(email);

		return new ResponseEntity<>(trainer, HttpStatus.OK);
=======
	
	@PostMapping(value = "promote")
	public ResponseEntity<TrainerUser> promote(@RequestBody TrainerUser tu) {
		TrainerUser t = trainerService.promoteToTrainer(tu);
		return new ResponseEntity<>(t, HttpStatus.OK);
>>>>>>> e20d8132f6df9cf1780bd9131c76c6bfa1f2665a
	}
	
	@PutMapping
	public ResponseEntity<TrainerUser> updateTrainer(@RequestBody TrainerUser tu) {
		TrainerUser t = trainerService.update(tu);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	
	@GetMapping(value = "/email/{email:.+}/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainerUser> findTrainerByEmail(@PathVariable String email) {
		log.info(email);
		log.info("Finding trainer by email of " + email);
		TrainerUser user = trainerService.findTrainerByEmail(email);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainerUser> findTrainerById(@PathVariable("id") Integer id) {
		log.info("Fetching trainer base on id.");
		return new ResponseEntity<TrainerUser>(trainerService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/titles")
	public ResponseEntity<List<String>> getTitles() {
		List<String> titles = trainerService.allTitles();
		return new ResponseEntity<List<String>>(titles, HttpStatus.OK);
}

	/**
	 * Deactivates the User account associated with the given TrainerId.
	 */
//	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> deleteByTrainerId(@PathVariable("id")) Integer id) {
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	
	@GetMapping
	public ResponseEntity<List<TrainerUser>> getAll() {
		List<TrainerUser> allTrainers = trainerService.getAll();
		return new ResponseEntity<List<TrainerUser>>(allTrainers, HttpStatus.OK);
	}
	

	/**
	 * Finds a user by unique firstname/lastname combination. This needs
	 * further thought.
	 */
//	@GetMapping
//	public ResponseEntity<TrainerUser> findByName(@PathVariable("firstName") String firstName,
//			@PathVariable("lastName") String lastName) {
//		TrainerUser trainer = trainerService.findByName(firstName, lastName);
//	}
	
	

// This has yet to be implemented. Required RabbitMQ.
//	/**
//	 * Returns all trainers titles from the database `
//	 *
//	 * @return
//	 */
//	@RequestMapping(value = "trainers/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	// @PreAuthorize("hasAnyRole('VP', 'TRAINER', 'STAGING', 'QC', 'PANEL')")
//	public ResponseEntity<List<TrainerRole>> getAllTrainersRoles() {
//		log.info("Fetching all trainers roles");
//		List<TrainerRole> trainers = trainerService.trainerRepository.findAllTrainerRoles();
//		return new ResponseEntity<>(trainers, HttpStatus.OK);
//	}

}
