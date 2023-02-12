package com.obrs.travels.models;

import java.time.LocalDate;

//import java.time.LocalDate;

import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reservation_id;

	private Boolean reservationStatus = true;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String reservationDate = "2023-02-12";

	@CreationTimestamp
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime reservationTime;

	private Double totalAmount;

	private Integer seatsBooked;

	@ManyToOne
	@JoinColumn(name = "busId")
	private Bus bus;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Integer getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Integer reservation_id) {
		this.reservation_id = reservation_id;
	}

	public Boolean getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(Boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}

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

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reservation(Integer reservation_id, Boolean reservationStatus,
			LocalTime reservationTime, Double totalAmount, Integer seatsBooked, Bus bus, User user) {
		super();
		this.reservation_id = reservation_id;
		this.reservationStatus = reservationStatus;
		this.reservationTime = reservationTime;
		this.totalAmount = totalAmount;
		this.seatsBooked = seatsBooked;
		this.bus = bus;
		this.user = user;
	}

	public Reservation() {

	}

}