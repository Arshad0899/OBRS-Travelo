package com.obrs.travels.repository;

import java.time.LocalDate;
//import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.Bus;
import com.obrs.travels.models.Owner;

public interface BusRepo extends JpaRepository<Bus, Integer> {
	
	public List<Bus> findByBoardingAndDestination(String boarding, String destination);
	
	public List<Bus> findByBoardingAndDestinationAndJourneyDateAndIsApproved(String boarding, String destination, LocalDate journetDate, Boolean isApproved);
	
	public List<Bus> findByIsApproved(Boolean isApproved);

	public List<Bus> findByOwner(Owner ownerId);
}
