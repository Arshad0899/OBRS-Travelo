package com.obrs.travels.service.impl;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.BookingDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.Bus;
import com.obrs.travels.models.User;
import com.obrs.travels.repository.BusRepo;
import com.obrs.travels.repository.UserRepo;
import com.obrs.travels.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BusRepo busRepo;

	@Override
	public BookingDto busBookingDetails(Integer busId, Integer userId) {

		Optional<User> optionalUser = this.userRepo.findById(userId);//.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		User user = optionalUser.get();
		
		System.out.println(user.getUserId());
		
		Bus bus = this.busRepo.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", busId));

		BookingDto bookingDto = new BookingDto();

		bookingDto.setBusId(bus.getBus_id());
		bookingDto.setUserId(user.getUserId());
		bookingDto.setPassengerName(user.getUserName());
		bookingDto.setPhoneNo(user.getPhoneNo());
		bookingDto.setBusName(bus.getBusname());
		bookingDto.setType(bus.getType());
		bookingDto.setFare(bus.getFare());
		bookingDto.setDestination(bus.getDestination());
		bookingDto.setBoarding(bus.getBoarding());
		bookingDto.setBoardingTime(bus.getStartTime());
		bookingDto.setArrivalTime(bus.getEndTime());
		bookingDto.setJourneyDate(bus.getJourneyDate());

//		System.out.println("Boarding Point: " + bookingDto.getBoarding());
//		System.out.println("Destination Point: " + bookingDto.getDestination());
		
		return bookingDto;
	}

}
