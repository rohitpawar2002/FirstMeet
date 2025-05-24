package com.firstmeet.FirstMeet.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstmeet.FirstMeet.model.User;
import com.firstmeet.FirstMeet.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController

public class UserDataController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/authenticate")
	public String addStudent(@RequestBody Map<String, String> payload) {
		String username = payload.get("username");
        String password = payload.get("password");
		System.out.println(username);
		System.out.println(password);
		if(repo.customUserSearch(username, password) != null)
		{
			System.out.println("login");
			return "login";
		}
		System.out.println("error");	
		return "error";
	}

}
