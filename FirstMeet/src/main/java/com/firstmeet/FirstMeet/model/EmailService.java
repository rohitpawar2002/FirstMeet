package com.firstmeet.FirstMeet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void sendRSVPNotification(String to, String meetingDesc, String employeeName, String status) {
        String subject = "RSVP Update for Your Meeting";
        String text = String.format("Hello,\n\nEmployee %s has %s the invitation for the meeting: %s.\n\nRegards,\nMeeting Scheduler System",
                employeeName, status, meetingDesc);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
