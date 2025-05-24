package com.firstmeet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
	@Id
	@Column(name="employeeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employeeId;
	String name;
	String email;
	Long phoneNumber;
	@ManyToOne
	@JoinColumn(name = "department_id") 
	Department department;
}
