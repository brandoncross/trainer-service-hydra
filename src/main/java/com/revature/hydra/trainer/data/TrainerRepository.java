package com.revature.hydra.trainer.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.SimpleTrainer;
import com.revature.beans.TrainerRole;

@Repository
public interface TrainerRepository extends JpaRepository<SimpleTrainer, Integer> {

	/**
	 * Create a list of all Trainers without references to other tables
	 *
	 * @param
	 *
	 * @return List of SimpleTrainers
	 */
	@Query("select distinct t from SimpleTrainer t where t.tier<>com.revature.beans.TrainerRole.ROLE_INACTIVE Order By t.trainerId asc")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<SimpleTrainer> findAll();

	/**
	 * Find a single Trainer without references by trainer id
	 *
	 * @param id
	 *
	 * @return SimpleTrainer
	 */
	@Query("select distinct t from SimpleTrainer t where t.trainerId = :id")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	SimpleTrainer findByTrainerId(@Param("id") Integer id);
	
	/**
	 * Find a single Trainer by name
	 *
	 * @param name
	 *
	 * @return SimpleTrainer
	 */
	@Query("select distinct t from SimpleTrainer t where t.name = :name")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	SimpleTrainer findByName(@Param("name") String name);
	
	/**
	 * Create a list of all unique titles for trainers
	 *
	 * @param
	 *
	 * @return List of Strings
	 */
	@Query("select distinct t.title from SimpleTrainer t")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	List<String> findAllTrainerTitles();
	
	/**
	 * Find a single Trainer without references by email
	 *
	 * @param email
	 *
	 * @return SimpleTrainer
	 */
	@Query("select distinct t from SimpleTrainer t where t.email = :email")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	SimpleTrainer findByEmail(@Param("email") String email);
	
	/**
	 * Update a single trainer's name, title, tier by finding them by an id
	 *
	 * @param name, title,tier, userId
	 *
	 * @return
	 */
	@Modifying
	@Query("update SimpleTrainer t set t.name = ?1, t.title = ?2, t.tier = ?3, t.resume = ?4 where t.trainerId = ?5")
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void updateTrainerInfoById(String name, String title, TrainerRole tier, String resume, Integer userId);
}
