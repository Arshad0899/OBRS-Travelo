package com.obrs.travels.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusDto {

	private Integer bus_id;
	private String busname;
	private String driverName;
	private String regNo;
	private String type;
	private String boarding;
	private String destination;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double fare;
	private Integer noOfSeats;
	private Integer seatsBooked;
	private Integer availableSeats;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate journeyDate;

	public Integer getBus_id() {
		return bus_id;
	}

	public void setBus_id(Integer bus_id) {
		this.bus_id = bus_id;
	}

	public String getBusname() {
		return busname;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBoarding() {
		return boarding;
	}

	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public Integer getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public BusDto(Integer bus_id, String busname, String driverName, String regNo, String type, String boarding,
			String destination, LocalTime startTime, LocalTime endTime, Double fare, Integer noOfSeats,
			Integer seatsBooked, Integer availableSeats, LocalDate journeyDate) {
		super();
		this.bus_id = bus_id;
		this.busname = busname;
		this.driverName = driverName;
		this.regNo = regNo;
		this.type = type;
		this.boarding = boarding;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.fare = fare;
		this.noOfSeats = noOfSeats;
		this.seatsBooked = seatsBooked;
		this.availableSeats = availableSeats;
		this.journeyDate = journeyDate;
	}

	public BusDto() {

	}

}
