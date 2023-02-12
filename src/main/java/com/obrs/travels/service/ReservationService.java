package com.obrs.travels.service;

import java.util.List;

import com.obrs.travels.dto.ConformationDto;
import com.obrs.travels.dto.PaymentDto;
import com.obrs.travels.dto.PaymentProcessDto;
import com.obrs.travels.dto.ReservationDto;
import com.obrs.travels.dto.reserveDto;


public interface ReservationService {

	PaymentProcessDto processReservation(ConformationDto conformationDto);
	
	ReservationDto deleteReservation(ReservationDto reservationDto);
	
	List<ReservationDto> viewAllReservations();
	
	ReservationDto viewReservationById(Integer reservationId);
	
	Boolean createReservation(reserveDto paymentDto);
	
}
