package com.revature.hydra.trainer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.SimpleTrainer;
import com.revature.beans.Trainer;
import com.revature.hydra.trainer.data.TrainerRepository;

@RestController
@RequestMapping(value = "/trainer")
public class TrainerService {

	@Autowired
	AmqpTemplate rabbitTemplate;

	@Autowired
	public TrainerRepository trainerRepository;

	@Autowired
	private TrainerMessagingService trainerMessagingService;

	private static final Logger log = Logger.getLogger(TrainerService.class);

	/**
	 * Save a SimpleTrainer
	 *
	 * @param SimpleTrainer
	 *
	 * @return
	 */
	public void save(SimpleTrainer trainer) {
		// if (trainer.getTrainerId() == 0)
		// trainer.setTrainerId(null);
		trainerRepository.save(trainer);
	}

	/**
	 * Update a Trainer
	 *
	 * @param trainer
	 *
	 * @return
	 */
	public void update(Trainer trainer) {
		// save(trainer);
		log.info("Trainer submitted was: " + trainer);
		trainerRepository.updateTrainerInfoById(trainer.getName(), trainer.getTitle(), trainer.getTier(),
				trainer.getResume(), trainer.getEmail(), trainer.getTrainerId());

	}

	/**
	 * Delete a single Trainer
	 *
	 * @param trainer
	 *
	 * @return
	 */
	public void delete(Trainer trainer) {
		trainerRepository.delete(trainer.getTrainerId());
	}

	/**
	 * Find a single Trainer by trainerId
	 *
	 * @param trainerId
	 *
	 * @return Trainer
	 */
	public SimpleTrainer findById(Integer trainerId) {
		log.info("Trainer Id: " + trainerId);
		SimpleTrainer basis = trainerRepository.findByTrainerId(trainerId);
		return basis;
		// Trainer result = composeTrainer(basis);
		// return result;
	}

	/**
	 * Find a single Trainer by name
	 *
	 * @param name
	 *
	 * @return Trainer
	 */
	public SimpleTrainer findByName(String name) {
		log.info("Name to find: " + name);
		SimpleTrainer basis = trainerRepository.findByName(name);
		return basis;
		// Trainer result = composeTrainer(basis);
		// return result;
	}

	/**
	 * Find a single Trainer by email
	 *
	 * @param trainerId
	 *
	 * @return Trainer
	 */
	public SimpleTrainer findByEmail(String email) {
		log.info("Email to find: " + email);
		SimpleTrainer basis = trainerRepository.findByEmail(email);
		return basis;
		// Trainer result = composeTrainer(basis);
		// return result;
	}

	/**
	 * Find all Trainers
	 *
	 * @param
	 *
	 * @return List of Trainers
	 */
	public List<SimpleTrainer> findAll() {
		List<Trainer> result = new ArrayList<Trainer>();
		List<SimpleTrainer> basis = trainerRepository.findAll();
		return basis;
		// for (SimpleTrainer t : basis) {
		// result.add(composeTrainer(t));
		// }
		//
		// return result;
	}

	/**
	 * convert a SimpleTrainer in to a Trainer Trainer has a set of batches
	 * associated with it SimpleTrainer does not
	 * 
	 * deprecated trash because useless and terrible
	 *
	 * @param src
	 *
	 * @return Trainer
	 */
	/*
	 * private Trainer composeTrainer(SimpleTrainer src) {
	 * log.info("Simple Trainer was: " + src);
	 * 
	 * List<SimpleBatch> batchSet =
	 * trainerCompositionMessagingService.sendListSimpleBatchRequest(src.
	 * getTrainerId()); Trainer dest = new Trainer(src); try {
	 * dest.setBatches(batchSet.stream().map(x -> new
	 * Batch(x)).collect(Collectors.toSet()));
	 * 
	 * // Added to populate batch ... for (Batch b : dest.getBatches()) { for
	 * (SimpleBatch simpleB : batchSet) { SimpleTrainer batchTrainer =
	 * trainerRepository.findByTrainerId(simpleB.getTrainerId()); b.setTrainer(new
	 * Trainer(batchTrainer));
	 * 
	 * if (simpleB.getCoTrainerId() != null) { SimpleTrainer batchCoTrainer =
	 * trainerRepository.findByTrainerId(simpleB.getCoTrainerId());
	 * b.setCoTrainer(new Trainer(batchCoTrainer)); }
	 * b.setTrainingType(simpleB.getTrainingType()); // List<SimpleTrainee>
	 * traineeSet = //
	 * trainerCompositionMessagingService.sendListSimpleTraineeRequest(b.getBatchId(
	 * )); // b.setTrainees(traineeSet.stream().map(y -> new //
	 * Trainee(y)).collect(Collectors.toSet())); } } } catch (NullPointerException
	 * e) { log.error(e.getMessage()); dest.setBatches(null); }
	 * 
	 * if (src.getSkillId() == null) { dest.setSkills(null); } else {
	 * List<SimpleSkill> skillList = new ArrayList<SimpleSkill>(); for (Integer
	 * skillId : src.getSkillId()) { SimpleSkill skill =
	 * trainerCompositionMessagingService.sendSingleSimpleSkillRequest(skillId);
	 * log.info("skill found was: " + skill + " with skill id of " + skillId); if
	 * (skill != null) skillList.add(skill); } dest.setSkills(skillList); } return
	 * dest; }
	 */
}