package com.obrs.travels.dto;

public class AdminDto {

	private Integer adminId;
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNo;
	private String email;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdmin_id(Integer adminId) {
		this.adminId = adminId;
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

	public AdminDto(Integer admin_id, String firstName, String lastName, String password, String phoneNo,
			String email) {
		super();
		this.adminId = admin_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public AdminDto() {

	}

}
