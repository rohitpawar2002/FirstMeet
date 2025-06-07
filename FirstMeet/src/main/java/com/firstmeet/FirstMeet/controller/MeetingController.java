package com.firstmeet.FirstMeet.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.firstmeet.FirstMeet.model.*;
import com.firstmeet.FirstMeet.repository.*;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/invited-meetings")
    public Object getPastInvitedMeetings(HttpServletRequest request) {
        String username = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("user")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        if (username == null) {
            return "Unauthorized: User not logged in";
        }

        User user = userRepository.findById(username).orElse(null);
        if (user == null || user.getEmployee() == null) {
            return "User or employee not found";
        }

        int employeeId = user.getEmployee().getEmployeeId();

        //DB query returns only completed meetings
        return meetingRepository.findPastMeetingsByInvitee(employeeId);
    }
    
    @GetMapping("/upcoming-meetings")
    public Object getUpcomingInvitedMeetings(HttpServletRequest request) {
        String username = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("user")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        if (username == null) {
            return "Unauthorized: User not logged in";
        }

        User user = userRepository.findById(username).orElse(null);
        if (user == null || user.getEmployee() == null) {
            return "User or employee not found";
        }

        int employeeId = user.getEmployee().getEmployeeId();

        return meetingRepository.findUpcomingMeetingsByInvitee(employeeId);
    }


}
