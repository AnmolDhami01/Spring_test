package com.onlyjavatech.springbootproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authours")
public class AuthourModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authourId;
	private String firstName;
	private String lastName;
	private String laungauge;

	public int getAuthourId() {
		return authourId;
	}

	public void setAuthourId(int authourId) {
		this.authourId = authourId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLaungauge() {
		return laungauge;
	}

	public void setLaungauge(String laungauge) {
		this.laungauge = laungauge;
	}
}
