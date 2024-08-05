package com.ali.Model;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="student")

public class StudentModel {
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	
	private String lastname; 
	
	private LocalDate localdate;
	
	@Column (unique = true)
	private String email;
	
	@Transient
	private int age;
	
	

	public StudentModel() {
		super();
	}

	public StudentModel(String firstname, String lastname, LocalDate localdate, String email, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.localdate = localdate;
		this.email = email;
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return Period.between(localdate, LocalDate.now()).getYears();
	}

	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}