package com.firstmeet.FirstMeet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="roomname")
	private String roomName;
	
	@Column(name="roomlocation")
	private String roomLocation;
	
	@Column(name="capacity")
	private int capacity;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int id, String roomName, String roomLocation, int capacity) {
		super();
		this.id = id;
		this.roomName = roomName;
		this.roomLocation = roomLocation;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomName=" + roomName + ", roomLocation=" + roomLocation + ", capacity=" + capacity
				+ "]";
	}
	
}
