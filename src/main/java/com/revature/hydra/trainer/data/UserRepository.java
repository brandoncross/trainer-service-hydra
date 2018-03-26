package com.revature.hydra.trainer.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	List<Integer> findAllUserRoles();

	User findbyName(String name);

}
