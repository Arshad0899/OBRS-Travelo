package com.obrs.travels.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.travels.dto.BusDto;
import com.obrs.travels.dto.UserDto;
import com.obrs.travels.service.BusService;
import com.obrs.travels.utility.ApiResponse;

@Controller
@RequestMapping(path = "travels/bus")
public class BusController {
	
	@Autowired
	private BusService busService;
	
	@GetMapping("/bus/add")
	public String displayAddBusPage() {
		return "addBus";
	}
	
	
	@PutMapping(path = "/{busId}")
	private ResponseEntity<BusDto> updateBus(@RequestBody BusDto busDto, @PathVariable("busId") Integer busId){
		BusDto updatedBusDto = this.busService.updateBus(busDto,busId);
		
		return ResponseEntity.ok(updatedBusDto);
	}
	
	@GetMapping(path = "/bus")
	public String showManageBusPage(Model model) {
		List<BusDto> bus = busService.getAllBus();
		model.addAttribute("busList", bus);
		return "manage-bus";
	}
	
	// Delete bus from DB
	@GetMapping("/bus/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer busId) {
		this.busService.deleteBus(busId);

		return "redirect:/travels/admin/bus";
	}
	
	@GetMapping("/bus/update/{userId}")
	public String showUpdateBusPage(@PathVariable("userId") Integer id, Model model) {

		BusDto bus = this.busService.getBusById(id);

		if (bus != null) {
			model.addAttribute("bus", bus);
			return "update-bus";
		} else {
			return "redirect:/travels/admin/bus";
		}

	}
	
	@PostMapping("/bus/update")
	public String updateBus(@ModelAttribute BusDto busDto) {
		this.busService.updateBus(busDto, busDto.getBus_id());
		return "redirect:/travels/admin/bus";
	}

	
//	@DeleteMapping(path = "/{busId}")
//	private ResponseEntity<ApiResponse> deleteBus(@PathVariable("busId") Integer busId){
//		this.busService.deleteBus(busId);
//		return new ResponseEntity<ApiResponse>(new ApiResponse("Bus deleted Sucussfully", true), HttpStatus.OK);
//	}
//	
//	@GetMapping(path = "/")
//	public ResponseEntity<List<BusDto>> getAllBuses(){
//		return ResponseEntity.ok(this.busService.getAllBus());
//	}
//	
//	@GetMapping(path = "/{busId}")
//	public ResponseEntity<BusDto> getBusById(@PathVariable("busId") Integer busId){
//		return ResponseEntity.ok(this.busService.getBusById(busId));
//	}
//	
//	@GetMapping(path = "/bus-route/")
//	public ResponseEntity<List<BusDto>> getBusByRoute(@RequestParam("boarding") String boarding, @RequestParam("destination") String destination){
//		return ResponseEntity.ok(this.busService.getBusByBoardingAndDestination(boarding, destination));
//	}
//	
//	@GetMapping(path = "/bus-route-date/")
//	public ResponseEntity<List<BusDto>> getBusByRouteAndDate(@RequestParam String boarding, @RequestParam String destination, @RequestParam LocalDate date){
//		return ResponseEntity.ok(this.busService.getBusByBoardingAndDestinationAndJourneyDate(boarding, destination, date));
//	}

}
