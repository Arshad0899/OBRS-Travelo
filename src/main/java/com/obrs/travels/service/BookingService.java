package com.obrs.travels.service;

import com.obrs.travels.dto.BookingDto;

public interface BookingService {

	public BookingDto busBookingDetails(Integer busId, Integer userId);
	
	
}
