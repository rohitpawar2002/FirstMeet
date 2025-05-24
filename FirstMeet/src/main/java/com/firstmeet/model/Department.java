package com.firstmeet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department")

public class Department {
	 
	@Id
	@Column(name="departmentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int departmentId;
	String name;
	
	public Department() {
		super();
	}
	
	public Department(int departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
