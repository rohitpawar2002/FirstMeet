package com.firstmeet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MOM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String action;
    private String owner;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "meetingId")
    private MeetingScheduler meeting;

	public MOM() {
		super();
	}

	public MOM(Long id, String topic, String action, String owner, String duration, MeetingScheduler meeting) {
		super();
		this.id = id;
		this.topic = topic;
		this.action = action;
		this.owner = owner;
		this.duration = duration;
		this.meeting = meeting;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public MeetingScheduler getMeeting() {
		return meeting;
	}

	public void setMeeting(MeetingScheduler meeting) {
		this.meeting = meeting;
	}
    
    
}
