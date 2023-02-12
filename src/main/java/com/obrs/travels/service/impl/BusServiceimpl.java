package com.obrs.travels.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.BusDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.Bus;
import com.obrs.travels.models.Owner;
import com.obrs.travels.models.User;
import com.obrs.travels.repository.BusRepo;
import com.obrs.travels.repository.OwnerRepo;
import com.obrs.travels.service.BusService;

@Service
public class BusServiceimpl implements BusService {

	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public BusDto createBus(BusDto busDto, Integer ownerId) {

		Optional<Owner> optionalOwner = this.ownerRepo.findById(ownerId);
		System.out.println("owner id: " + ownerId);
		Owner owner = optionalOwner.get();
		
		Bus bus = this.dtoToBus(busDto);
		bus.setOwner(owner);
		Bus savedBus = this.busRepo.save(bus);
		return this.busToDto(savedBus); 
		
	}

	@Override
	public BusDto updateBus(BusDto busDto, Integer busId) {

		Optional<Bus> optionalBus = this.busRepo.findById(busId);

		Bus bus = optionalBus.get();

		if (optionalBus.isPresent()) {
			bus.setBusname(busDto.getBusname());
			bus.setDriverName(busDto.getDriverName());
			bus.setRegNo(busDto.getRegNo());
			bus.setType(busDto.getType());
			bus.setBoarding(busDto.getBoarding());
			bus.setDestination(busDto.getDestination());
			bus.setStartTime(busDto.getStartTime());
			bus.setEndTime(busDto.getEndTime());
			bus.setFare(busDto.getFare());
			bus.setNoOfSeats(busDto.getNoOfSeats());
			bus.setSeatsBooked(busDto.getSeatsBooked());
			bus.setAvailableSeats(busDto.getAvailableSeats());
			bus.setJourneyDate(busDto.getJourneyDate());

			Bus updatedBus = this.busRepo.save(bus);

			return this.busToDto(updatedBus);

		} else {

			return null;

		}

	}

	@Override
	public BusDto getBusById(Integer busId) {

		Bus bus = this.busRepo.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", busId));

		return this.busToDto(bus);
	}

	@Override
	public List<BusDto> getAllBus() {

		List<Bus> buses = this.busRepo.findByIsApproved(true);
		List<BusDto> busDtos = buses.stream().map(Bus -> this.busToDto(Bus)).collect(Collectors.toList());

		return busDtos;
	}

	@Override
	public void deleteBus(Integer busId) {

		Bus bus = this.busRepo.findById(busId).orElseThrow(() -> new ResourceNotFoundException("Bus", "id", busId));

		this.busRepo.delete(bus);
	}
	
	@Override
	public List<BusDto> getBusByBoardingAndDestination(String boarding, String destination) {

		List<Bus> buses = this.busRepo.findByBoardingAndDestination(boarding, destination);
		List<BusDto> busDtos = buses.stream().map(Bus -> this.busToDto(Bus)).collect(Collectors.toList());

		return busDtos;
	}

	@Override
	public List<BusDto> getBusByBoardingAndDestinationAndJourneyDateAndIsApproved(String boarding, String destination,
			LocalDate journetDate, Boolean isApproved) {

		List<Bus> buses = this.busRepo.findByBoardingAndDestinationAndJourneyDateAndIsApproved(boarding, destination, journetDate, isApproved);
		List<BusDto> busDtos = buses.stream().map(Bus -> this.busToDto(Bus)).collect(Collectors.toList());
		return busDtos;
	}
	
	@Override
	public List<BusDto> getBusByIsApproved(Boolean isApproved) {
		List<Bus> buses = this.busRepo.findByIsApproved(isApproved);
		List<BusDto> busDtos = buses.stream().map(Bus -> this.busToDto(Bus)).collect(Collectors.toList());
		return busDtos;
	}
	
	@Override
	public BusDto approveBusById(Integer busId) {
		
		Optional<Bus> optionalBus = this.busRepo.findById(busId);

		Bus bus = optionalBus.get();

		if (optionalBus.isPresent()) {
			
			bus.setIsApproved(true);
			
			Bus updatedBus = this.busRepo.save(bus);

			return this.busToDto(updatedBus);

		} else {

			return null;

		}
	}

	private Bus dtoToBus(BusDto dto) {

		Bus bus = new Bus();

		bus.setBus_id(dto.getBus_id());
		bus.setBusname(dto.getBusname());
		bus.setDriverName(dto.getDriverName());
		bus.setRegNo(dto.getRegNo());
		bus.setType(dto.getType());
		bus.setBoarding(dto.getBoarding());
		bus.setDestination(dto.getDestination());
		bus.setStartTime(dto.getStartTime());
		bus.setEndTime(dto.getEndTime());
		bus.setFare(dto.getFare());
		bus.setNoOfSeats(dto.getNoOfSeats());
		bus.setSeatsBooked(dto.getSeatsBooked());
		bus.setAvailableSeats(dto.getAvailableSeats());
		bus.setJourneyDate(dto.getJourneyDate());

		return bus;
	}

	private BusDto busToDto(Bus bus) {

		BusDto dto = new BusDto();

		dto.setBus_id(bus.getBus_id());
		dto.setBusname(bus.getBusname());
		dto.setDriverName(bus.getDriverName());
		dto.setRegNo(bus.getRegNo());
		dto.setType(bus.getType());
		dto.setBoarding(bus.getBoarding());
		dto.setDestination(bus.getDestination());
		dto.setStartTime(bus.getStartTime());
		dto.setEndTime(bus.getEndTime());
		dto.setFare(bus.getFare());
		dto.setNoOfSeats(bus.getNoOfSeats());
		dto.setSeatsBooked(bus.getSeatsBooked());
		dto.setAvailableSeats(bus.getAvailableSeats());
		dto.setJourneyDate(bus.getJourneyDate());

		return dto;
	}

	@Override
	public List<BusDto> getBusByOwnerId(Integer ownerId) {
		
		Optional<Owner> optionalOwner = this.ownerRepo.findById(ownerId);
		
		Owner owner = optionalOwner.get();

		List<Bus> buses = this.busRepo.findByOwner(owner);
		
		
		List<BusDto> busDtos = buses.stream().map(Bus -> this.busToDto(Bus)).collect(Collectors.toList());

		return busDtos;
	}
}
