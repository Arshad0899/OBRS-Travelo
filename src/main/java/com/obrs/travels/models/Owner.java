package com.obrs.travels.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "OWNER")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ownerId;
	private String ownerName;
	private String userName;
	private String emailId;
	private String password;
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Bus> buses = new ArrayList<>();

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	
	
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Owner(Integer ownerId, String ownerName, String userName, String emailId, String password, String address,
			List<Bus> buses) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
		this.buses = buses;
	}

}
