package com.obrs.travels.dto;

public class OwnerDto {

	private Integer ownerId;
	private String ownerName;
	private String username;
	private String emailId;
	private String password;
	private String address;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public OwnerDto(String ownerName, String username, String emailId, String password, String address) {
		super();
		this.ownerName = ownerName;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.address = address;
	}

	public OwnerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
