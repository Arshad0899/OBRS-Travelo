package com.obrs.travels.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BUS")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bus_id;

	private String busName;

	private String driverName;

	private String regNo;

	private String type;

	@Column(nullable = false)
	private String boarding;

	@Column(nullable = false)
	private String destination;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(nullable = false)
	private LocalTime startTime;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@Column(nullable = false)
	private LocalTime endTime;

	private Double fare;

	private Integer noOfSeats;

	private Integer seatsBooked;

	private Integer availableSeats;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(nullable = false)
	private LocalDate journeyDate;

	private Boolean isApproved = false;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "bus")
	private List<Reservation> reservations = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	// Getter and Setters
	
	
	
	public Integer getBus_id() {
		return bus_id;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setBus_id(Integer bus_id) {
		this.bus_id = bus_id;
	}

	public String getBusname() {
		return busName;
	}

	public void setBusname(String busname) {
		this.busName = busname;
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

	public void setEndTime(LocalTime arrivalTime) {
		this.endTime = arrivalTime;
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
	
	

	public Bus(Integer bus_id, String busname, String driverName, String regNo, String type, String boarding,
			String destination, LocalTime startTime, LocalTime arrivalTime, Double fare, Integer noOfSeats,
			Integer seatsBooked, Integer availableSeats, LocalDate journeyDate) {
		super();
		this.bus_id = bus_id;
		this.busName = busname;
		this.driverName = driverName;
		this.regNo = regNo;
		this.type = type;
		this.boarding = boarding;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = arrivalTime;
		this.fare = fare;
		this.noOfSeats = noOfSeats;
		this.seatsBooked = seatsBooked;
		this.availableSeats = availableSeats;
		this.journeyDate = journeyDate;
	}

	public Bus() {

	}

}