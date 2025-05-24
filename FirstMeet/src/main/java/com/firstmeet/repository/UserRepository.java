package com.firstmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firstmeet.FirstMeet.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query(value="select username from User where username=?1 and password=?2")
	public User customUserSearch(String userid, String pwd);
}
