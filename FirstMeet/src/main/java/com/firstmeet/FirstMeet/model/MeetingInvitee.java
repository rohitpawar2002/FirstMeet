package com.firstmeet.FirstMeet.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "meeting_invitees")
public class MeetingInvitee {

    @EmbeddedId
    private MeetingInviteeId id;

    @ManyToOne
    @MapsId("meetingId")  // maps meetingId attribute of embedded id
    @JoinColumn(name = "meeting_id")
    private MeetingScheduling meeting;

    @ManyToOne
    @MapsId("employeeId")  // maps employeeId attribute of embedded id
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "rsvp_status")
    private String rsvpStatus = "PENDING";

    public MeetingInvitee() {}

    public MeetingInvitee(MeetingScheduling meeting, Employee employee, String rsvpStatus) {
        this.meeting = meeting;
        this.employee = employee;
        this.rsvpStatus = rsvpStatus;
        this.id = new MeetingInviteeId(meeting.getMeetingId(), employee.getEmployeeId());
    }

    // Getters and setters
    public MeetingInviteeId getId() {
        return id;
    }

    public void setId(MeetingInviteeId id) {
        this.id = id;
    }

    public MeetingScheduling getMeeting() {
        return meeting;
    }

    public void setMeeting(MeetingScheduling meeting) {
        this.meeting = meeting;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRsvpStatus() {
        return rsvpStatus;
    }

    public void setRsvpStatus(String rsvpStatus) {
        this.rsvpStatus = rsvpStatus;
    }
}
