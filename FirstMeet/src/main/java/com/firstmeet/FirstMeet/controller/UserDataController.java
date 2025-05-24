package com.firstmeet.FirstMeet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstmeet.FirstMeet.model.User;
import com.firstmeet.FirstMeet.repository.UserRepository;

@RestController

public class UserDataController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/login")
	public String addStudent(User object) {
		String username = object.getUsername();
		String password = object.getPassword();
		
		if(repo.customUserSearch(username, password) != null)
			return "login";
		return "error";
	}

}
