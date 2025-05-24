package com.firstmeet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user")

public class User {
	
	@Id
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	Employee employee;
	
	public User() {
		super();
	}

	public User(String username, String password, Employee employee) {
		super();
		this.username = username;
		this.password = password;
		this.employee = employee;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	 
}
