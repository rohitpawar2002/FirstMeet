package com.firstmeet.FirstMeet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="meetingscheudling")

public class MeetingScheduling {
	
	@Id
	@Column(name="meetingId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int meetingId;
	private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDate meetingDate;
    String description;
    
    
    @ManyToOne
	@JoinColumn(name = "host")
	Employee employee;
    
    @ManyToOne
	@JoinColumn(name = "room_id")
	Room room;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "meeting_invitees",
        joinColumns = @JoinColumn(name = "meeting_id"),
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> invitees;

	public MeetingScheduling() {
		super();
	}

	public MeetingScheduling(int meetingId, LocalDateTime startTime, LocalDateTime endTime, LocalDate meetingDate,
            String description, Employee employee, Room room, List<Employee> invitees) {
		this.meetingId = meetingId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.meetingDate = meetingDate;
		this.description = description;
		this.employee = employee;
		this.room = room;
		this.invitees = invitees;
	}

	
	 // Getter & Setter
    public List<Employee> getInvitees() {
        return invitees;
    }

    public void setInvitees(List<Employee> invitees) {
        this.invitees = invitees;
    }

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
   
}
