package com.onefactor.user.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="candidate")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, unique=true)

	private String email;
	
	private String fname;
	
	private String lname;
	
	private String gender; 
	
	private String companyName;
	
	private String companyId;
	
	private String careerStatus;
	
	private String lookingFor;
	
	private String preferredRole;
	
	private List<String> skills;
	
	private String currentLocation;
	
	private String preferredLocation;
	
	private String preferredSalary;
	
	private String joinin;
	
	private List<String> internships;
	
	private String degree;
	
	private String specialization;
	
	private String school;
	
	private String passYear;
	
	private String resumeLink;
	
	private String yourRole;
	
	private String phone;
	
	private boolean isEmailVerified = false;
	
	private boolean isPhoneVerified	= false;
	
}
