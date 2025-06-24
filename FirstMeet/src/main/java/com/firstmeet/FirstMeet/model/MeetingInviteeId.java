package com.firstmeet.FirstMeet.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MeetingInviteeId implements Serializable {

    @Column(name = "meeting_id")
    private int meetingId;

    @Column(name = "employee_id")
    private int employeeId;

    public MeetingInviteeId() {}

    public MeetingInviteeId(int meetingId, int employeeId) {
        this.meetingId = meetingId;
        this.employeeId = employeeId;
    }

    // Getters and setters

    public int getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(int meetingId) {
        this.meetingId = meetingId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // equals and hashCode - very important for composite key identity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeetingInviteeId)) return false;
        MeetingInviteeId that = (MeetingInviteeId) o;
        return meetingId == that.meetingId &&
               employeeId == that.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId, employeeId);
    }
}