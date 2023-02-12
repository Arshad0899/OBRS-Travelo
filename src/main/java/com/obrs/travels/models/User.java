package com.obrs.travels.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(unique = true, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String firstName;

	private String lastName;

	private Integer age;

	@Column(name = "password", nullable = false, length = 14)
	private String password;

	private String gender;

	private String phoneNo;

	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Reservation> reservations = new ArrayList<>();

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//	private List<Payment> payments = new ArrayList<>();

	// Getters and Setters
	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {

	}

	public User(Integer userId, String userName, String firstName, String lastName, Integer age, String password, String gender, String phoneNo,
			String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.password = password;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [user_id=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}

}