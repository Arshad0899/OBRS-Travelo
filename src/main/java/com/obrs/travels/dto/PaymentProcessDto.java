package com.obrs.travels.dto;

public class PaymentProcessDto {

//	private Integer userId;
	private Integer busId;
	private double amount;
	private Integer SeatsBooked;

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public Integer getSeatsBooked() {
		return SeatsBooked;
	}

	public void setSeatsBooked(Integer seatsBooked) {
		SeatsBooked = seatsBooked;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentProcessDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentProcessDto(Integer busId, double amount, Integer seatsBooked) {
		super();
		this.busId = busId;
		this.amount = amount;
		SeatsBooked = seatsBooked;
	}


}
