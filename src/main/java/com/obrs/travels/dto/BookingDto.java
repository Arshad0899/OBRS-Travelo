package com.obrs.travels.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingDto {

	private Integer busId;
	private Integer userId;
	private String passengerName;
	private String phoneNo;
	private String busName;
	private String type;
	private Double fare;
	private Integer noOfSeatsBooked;
	private String destination;
	private String boarding;
	private LocalTime boardingTime;
	private LocalTime arrivalTime;
	private LocalDate journeyDate;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNoOfSeatsBooked() {
		return noOfSeatsBooked;
	}

	public void setNoOfSeatsBooked(Integer noOfSeatsBooked) {
		this.noOfSeatsBooked = noOfSeatsBooked;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public LocalTime getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(LocalTime boardingTime) {
		this.boardingTime = boardingTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public BookingDto(Integer busId, Integer userId, String passengerName, String type, Integer noOfSeatsBooked,
			String destination, String boarding, LocalTime boardingTime, LocalTime arrivalTime, LocalDate journeyDate) {
		super();
		this.busId = busId;
		this.userId = userId;
		this.passengerName = passengerName;
		this.type = type;
		this.noOfSeatsBooked = noOfSeatsBooked;
		this.destination = destination;
		this.boarding = boarding;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
		this.journeyDate = journeyDate;
	}

	public BookingDto() {

	}

}