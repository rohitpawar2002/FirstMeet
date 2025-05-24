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
}
