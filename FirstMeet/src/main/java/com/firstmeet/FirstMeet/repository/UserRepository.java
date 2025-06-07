package com.firstmeet.FirstMeet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firstmeet.FirstMeet.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Optional<User> findByUsernameAndPassword(String username, String password);
}
