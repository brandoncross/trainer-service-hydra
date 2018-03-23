package com.revature.hydra.trainer.service;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.beans.SimpleBatch;
import com.revature.beans.SimpleSkill;
import com.revature.beans.SimpleTrainee;

@Service
public class TrainerMessagingService {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	private static final String LIST_BATCH_ROUTING_KEY = "BSVihZkuxwdg9Dxy";
	private static final String LIST_TRAINEE_ROUTING_KEY = "eRQ7GaBRnHgGdV9D";
	private static final String SINGLE_SKILL_ROUTING_KEY = "utMPxDus2M9qy9Bh";
	private static final String RABBIT_REPO_EXCHANGE = "revature.hydra.repos";

	/**
	 * Send a message to Batch to find all batches associated with a given trainer id
	 *
	 * @param trainerId
	 *
	 * @return List of SimpleBatch
	 */
	public List<SimpleBatch> sendListSimpleBatchRequest(Integer trainerId) {
		JsonObject batchRequest = new JsonObject();

		batchRequest.addProperty("methodName", "findAllByTrainerId");
		batchRequest.addProperty("trainerId", trainerId);

		return (List<SimpleBatch>) rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_BATCH_ROUTING_KEY,
				batchRequest.toString());
	}
	
	/**
	 * Send a message to Trainee to find all trainees associated with a given batch id
	 *
	 * @param batchId
	 *
	 * @return List of SimpleTrainee
	 */
	public List<SimpleTrainee> sendListSimpleTraineeRequest(Integer batchId) {
		JsonObject traineeRequest = new JsonObject();

		traineeRequest.addProperty("methodName", "findAllByBatchId");
		traineeRequest.addProperty("batchId", batchId);

		return (List<SimpleTrainee>) rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, LIST_TRAINEE_ROUTING_KEY,
				traineeRequest.toString());
	}
	
	/**
	 * Send a message to Skill to find a single skill associated with a given skill id
	 *
	 * @param skill id
	 *
	 * @return SimpleSkill
	 */
	public SimpleSkill sendSingleSimpleSkillRequest(Integer skillId) {
		JsonObject skillRequest = new JsonObject();

		skillRequest.addProperty("methodName", "findOne");
		skillRequest.addProperty("skillId", skillId);

		return (SimpleSkill) rabbitTemplate.convertSendAndReceive(RABBIT_REPO_EXCHANGE, SINGLE_SKILL_ROUTING_KEY,
				skillRequest.toString());
	}
}