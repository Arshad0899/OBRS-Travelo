package com.obrs.travels.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.ConformationDto;
import com.obrs.travels.dto.PaymentDto;
import com.obrs.travels.dto.PaymentProcessDto;
import com.obrs.travels.dto.ReservationDto;
import com.obrs.travels.dto.reserveDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.Bus;
import com.obrs.travels.models.Reservation;
import com.obrs.travels.models.User;
import com.obrs.travels.repository.BusRepo;
import com.obrs.travels.repository.ReservationRepo;
import com.obrs.travels.repository.UserRepo;
import com.obrs.travels.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ReservationRepo reservationRepo;

//	@Autowired
//	private PaymentProcessDto paymentProcessDto;

	@Override
	public PaymentProcessDto processReservation(ConformationDto conformationDto) {

		Integer busId = conformationDto.getBusId();

		Bus bus = this.busRepo.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", busId));
		
		Integer noOfSeats = conformationDto.getNoOfSeats();
		Integer availableSeats = bus.getAvailableSeats();
		Integer updatedSeats = availableSeats - noOfSeats;
		
		bus.setAvailableSeats(updatedSeats);
		bus.setSeatsBooked(noOfSeats);
		
		this.busRepo.save(bus);
		
		Double price = conformationDto.getFare();
		Double totalPrice = price * noOfSeats;
		Integer userId = conformationDto.getUserId();

		PaymentProcessDto paymentProcessDto = new PaymentProcessDto();

		paymentProcessDto.setAmount(totalPrice);
		paymentProcessDto.setSeatsBooked(noOfSeats);
		paymentProcessDto.setBusId(bus.getBus_id());

		return paymentProcessDto;
	}

	@Override
	public ReservationDto deleteReservation(ReservationDto reservationDto) {

		return null;
	}

	@Override
	public List<ReservationDto> viewAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationDto viewReservationById(Integer reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createReservation(reserveDto reserve) {
		
		Reservation reservation = new Reservation();
		
		Bus bus = this.busRepo.findById(reserve.getBusId()).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", reserve.getBusId()));
		User user = this.userRepo.findById(reserve.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", reserve.getUserId()));
		
		reservation.setTotalAmount(reserve.getTotalAmount());
		reservation.setSeatsBooked(reserve.getSeatsBooked());
		reservation.setBus(bus);
		reservation.setUser(user);
		
		this.reservationRepo.save(reservation);
		
		return true;
	}

}
