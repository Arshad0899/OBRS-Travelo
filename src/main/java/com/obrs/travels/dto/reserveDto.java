package com.obrs.travels.dto;

public class reserveDto {
	
	private Double totalAmount;
	private Integer seatsBooked;
	private Integer busId;
	private Integer userId;
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public Integer getBusId() {
		return busId;
	}
	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public reserveDto(Double totalAmount, Integer seatsBooked, Integer busId, Integer userId) {
		super();
		this.totalAmount = totalAmount;
		this.seatsBooked = seatsBooked;
		this.busId = busId;
		this.userId = userId;
	}
	
	

}
