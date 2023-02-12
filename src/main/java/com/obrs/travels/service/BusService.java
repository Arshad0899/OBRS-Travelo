package com.obrs.travels.service;

import java.time.LocalDate;
import java.util.List;

import com.obrs.travels.dto.BusDto;

public interface BusService {
	
	BusDto createBus(BusDto busDto, Integer ownerId);

	BusDto updateBus(BusDto busDto, Integer busId);

	BusDto getBusById(Integer busId);

	List<BusDto> getAllBus();

	void deleteBus(Integer busId);
	
	List<BusDto> getBusByBoardingAndDestination(String boarding, String destination);
	
//	List<BusDto> getBusByBoardingAndDestinationAndJourneyDate(String boarding, String destination, LocalDate journetDate);
	
	List<BusDto> getBusByIsApproved(Boolean isApproved);
	
	BusDto approveBusById(Integer busId);

	List<BusDto> getBusByBoardingAndDestinationAndJourneyDateAndIsApproved(String boarding, String destination,
			LocalDate journetDate, Boolean isApproved);
	
	List<BusDto> getBusByOwnerId(Integer ownerId);
	
}
