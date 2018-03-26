package com.revature.hydra.trainer.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.BatchTrainer;
import com.revature.beans.SimpleTrainer;

public interface TrainerRepository extends JpaRepository<BatchTrainer, Integer> {

	BatchTrainer findByTrainerId(Integer trainerId);

	BatchTrainer findByUserId(Integer userId);

}
