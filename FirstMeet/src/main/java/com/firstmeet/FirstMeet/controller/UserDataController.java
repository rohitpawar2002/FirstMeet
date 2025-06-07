package com.firstmeet.FirstMeet.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstmeet.FirstMeet.model.User;
import com.firstmeet.FirstMeet.repository.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController

public class UserDataController {
	
	@Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody Map<String, String> payload, HttpServletResponse response) {
        String username = payload.get("username");
        String password = payload.get("password");

        return userRepository.findByUsernameAndPassword(username, password)
            .map(user -> {
                System.out.println("Login successful: " + user.getUsername());
                
             // Set cookie with username
                Cookie cookie = new Cookie("user", user.getUsername());
                cookie.setPath("/"); // makes it accessible to all endpoints
                cookie.setMaxAge(60 * 60); // 1 hour (in seconds)
                response.addCookie(cookie);
                return ResponseEntity.ok("login");
            })
            .orElseGet(() -> {
                System.out.println("Login failed");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("error");
            });
    }

}
