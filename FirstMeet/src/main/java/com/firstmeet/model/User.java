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
	String password;
	@OneToOne
	@JoinColumn(name = "employee_id")
	Employee employee;
}
