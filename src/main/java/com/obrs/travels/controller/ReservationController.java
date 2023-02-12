package com.obrs.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obrs.travels.dto.BookingDto;
import com.obrs.travels.dto.ConformationDto;
import com.obrs.travels.dto.PaymentProcessDto;
import com.obrs.travels.dto.ReservationDto;
import com.obrs.travels.dto.reserveDto;
import com.obrs.travels.service.BookingService;
import com.obrs.travels.service.ReservationService;

@Controller
@RequestMapping(path = "/travels/user/reservation")
public class ReservationController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private ReservationService reservationService;

	@GetMapping(path = "/book")
	public String showReservationPage(@RequestParam("busId") Integer busId, @RequestParam("userId") Integer userId,
			Model model) {
		BookingDto bookingDto = this.bookingService.busBookingDetails(busId, userId);
		model.addAttribute("booking", bookingDto);

		return "booking-page";

	}

	@PostMapping(path = "/conformation")
	public String paymentProcessing(@RequestParam("userId") Integer userId, @RequestParam("busId") Integer busId, @RequestParam("fare") Double totalAmount, @ModelAttribute ConformationDto conform, Model model) {
		
		reserveDto reserveDto = new reserveDto(totalAmount, conform.getNoOfSeats(), busId, userId);
		
		PaymentProcessDto process = this.reservationService.processReservation(conform);
		Boolean reserve = this.reservationService.createReservation(reserveDto);

		model.addAttribute("procee", process);
		return "payment-page";
	}

}
