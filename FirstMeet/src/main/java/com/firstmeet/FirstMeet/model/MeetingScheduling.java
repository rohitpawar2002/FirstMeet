package com.firstmeet.FirstMeet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "meetingscheudling")
public class MeetingScheduling {

    @Id
    @Column(name = "meetingId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int meetingId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate meetingDate;
    private String description;

    @ManyToOne
    @JoinColumn(name = "host")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // Replacing @ManyToMany with @OneToMany to MeetingInvitee
    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MeetingInvitee> invitees;

    // Constructors
    public MeetingScheduling() {}

    public MeetingScheduling(int meetingId, LocalDateTime startTime, LocalDateTime endTime, LocalDate meetingDate,
                             String description, Employee employee, Room room, List<MeetingInvitee> invitees) {
        this.meetingId = meetingId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.meetingDate = meetingDate;
        this.description = description;
        this.employee = employee;
        this.room = room;
        this.invitees = invitees;
    }

    // Getters and Setters
    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<MeetingInvitee> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<MeetingInvitee> invitees) {
        this.invitees = invitees;
    }
}
