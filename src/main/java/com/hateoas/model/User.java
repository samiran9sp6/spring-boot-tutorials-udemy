package com.hateoas.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private int id;
	@Size(min = 3,max = 25,message = "Length should be between 3 to 25")
	private String name;
	private String age;
	@Past
	private Date dob;
	
	public User(int id, String name, String age, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dob = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
