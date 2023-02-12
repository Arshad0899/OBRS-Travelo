package com.obrs.travels.dto;

public class ConformationDto {

	private Integer userId;
	private Integer busId;
	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	private Integer noOfSeats;
	private Double fare;

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public ConformationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConformationDto(Integer userId, Integer noOfSeats, Double fare) {
		super();
		this.userId = userId;
		this.noOfSeats = noOfSeats;
		this.fare = fare;
	}

}
