package com.firstmeet.FirstMeet.model;

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
	
	@Column(name="name")
	String name;
	
	@Column(name="email")
	String email;
	
	@Column(name="phonenumber")
	Long phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "department_id") 
	Department department;
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeId, String name, String email, Long phoneNumber, Department department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}
	 
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
