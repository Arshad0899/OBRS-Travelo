package com.obrs.travels.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.obrs.travels.models.Bus;
import com.obrs.travels.models.User;

public class ReservationDto {

	private Integer reservation_id;
	private Boolean reservationStatus;
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private Double totalAmount;
	private Integer seatsBooked;
	private Bus bus;
	private User user;

	public ReservationDto(Integer reservation_id, Boolean reservationStatus, LocalDate reservationDate,
			LocalTime reservationTime, Double totalAmount, Integer seatsBooked, Bus bus, User user) {
		super();
		this.reservation_id = reservation_id;
		this.reservationStatus = reservationStatus;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.totalAmount = totalAmount;
		this.seatsBooked = seatsBooked;
		this.bus = bus;
		this.user = user;
	}

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

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
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

	public ReservationDto() {

	}

}
