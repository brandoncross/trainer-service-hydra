package com.revature.hydra.trainer.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleTrainer;
import com.revature.beans.Trainer;
import com.revature.beans.TrainerRole;

import com.revature.beans.User;
import com.revature.hydra.trainer.service.TrainerService;
import com.revature.hydra.trainer.service.UserService;




@RestController
@CrossOrigin
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
	
	/**
	 * Create trainer
	 *
	 * @param trainer
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "trainers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAnyRole('VP')")
	public ResponseEntity<SimpleTrainer> createTrainer(@RequestBody SimpleTrainer trainer) {
		log.info("Saving trainer: " + trainer);
		trainerService.save(trainer);
		return new ResponseEntity<>(trainer, HttpStatus.CREATED);
	}

	/**
	 * Update trainer
	 *
	 * @param trainer
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "trainers", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAnyRole('VP')")
	public ResponseEntity<Void> updateTrainer(@Valid @RequestBody Trainer trainer) {
		log.info("Updating trainer: " + trainer);
		trainerService.update(trainer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

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
	}

	/**
	 * Deactivates the trainer, but does not delete them from database
	 *
	 * @param trainer
	 * @return response entity
	 */
	// AssignForce deletes based on Id
	@RequestMapping(value = "trainers", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAnyRole('VP')")
	public ResponseEntity<Void> makeInactive(@Valid @RequestBody Trainer trainer) {
		log.info("Updating trainer: " + trainer);
		trainer.setTier(TrainerRole.ROLE_INACTIVE);
		trainerService.update(trainer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Returns all trainers titles from the database `
	 *
	 * @return
	 */
	@RequestMapping(value = "trainers/titles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAnyRole('VP', 'TRAINER', 'STAGING', 'QC', 'PANEL')")
	public ResponseEntity<List<String>> getAllTrainersTitles() {
		log.info("Fetching all trainers titles");
		List<String> trainers = trainerService.trainerRepository.findAllTrainerTitles();
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * Returns all trainers titles from the database `
	 *
	 * @return
	 */
	@RequestMapping(value = "trainers/roles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	// @PreAuthorize("hasAnyRole('VP', 'TRAINER', 'STAGING', 'QC', 'PANEL')")
	public ResponseEntity<List<TrainerRole>> getAllTrainersRoles() {
		log.info("Fetching all trainers roles");
		List<TrainerRole> trainers = trainerService.trainerRepository.findAllTrainerRoles();
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	/**
	 * Returns all trainers from the database `
	 *
	 * @return
	 */
	@RequestMapping(value = "trainers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	// @PreAuthorize("hasAnyRole('VP', 'TRAINER', 'STAGING', 'QC', 'PANEL')")
	public ResponseEntity<List<SimpleTrainer>> getAllTrainers() {
		log.info("Fetching all trainers");
		List<SimpleTrainer> trainers = trainerService.findAll();
		return new ResponseEntity<>(trainers, HttpStatus.OK);
	}

	// AssignForce Specific Mappings
	/**
	 * Returns a trainer by their id.
	 * 
	 * @param id
	 * @return Trainer
	 */
	@RequestMapping(value = "trainer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<SimpleTrainer> findTrainerById(@PathVariable("id") Integer id) {
		log.info("Fetching trainer base on id.");
		return new ResponseEntity<>(trainerService.findById(id), HttpStatus.OK);
	}

	/**
	 * Returns trainer by their name
	 * 
	 * @param firstName,
	 *            lastName Assumes that a trainer's name field is stored as
	 *            "firstName lastName"
	 * 
	 * @return Trainer
	 */
	@RequestMapping(value = "trainer/{firstName}/{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleTrainer> findByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		String name = firstName + " " + lastName;
		return new ResponseEntity<>(trainerService.findByName(name), HttpStatus.FOUND);
	}

}
