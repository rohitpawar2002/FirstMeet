package com.firstmeet.FirstMeet.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private MeetingInviteeRepository meetingInviteeRepository;


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

    
    @PostMapping("/rsvp")
    public ResponseEntity<String> rsvpToMeeting(@RequestBody RSVPRequestDTO request) {
        Optional<MeetingInvitee> optionalInvitee = meetingInviteeRepository
            .findByMeeting_MeetingIdAndEmployee_EmployeeId(request.getMeetingId(), request.getEmployeeId());

        if (optionalInvitee.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invitee not found for this meeting");
        }

        MeetingInvitee invitee = optionalInvitee.get();
        String status = request.getRsvpStatus().toUpperCase();

        if (!status.equals("ACCEPTED") && !status.equals("DECLINED")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid RSVP status");
        }

        invitee.setRsvpStatus(status);
        meetingInviteeRepository.save(invitee);

        // ✅ Send email to host
        //String hostEmail = invitee.getMeeting().getEmployee().getUser().getEmail(); // assuming employee -> user -> email
        String hostEmail = invitee.getMeeting().getEmployee().getEmail();
        String meetingDesc = invitee.getMeeting().getDescription();
        String employeeName = invitee.getEmployee().getName();

        emailService.sendRSVPNotification(hostEmail, meetingDesc, employeeName, status);

        return ResponseEntity.ok("RSVP status updated and host notified");
    }

}
