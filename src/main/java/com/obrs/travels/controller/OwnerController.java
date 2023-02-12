package com.obrs.travels.controller;

import org.hibernate.mapping.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obrs.travels.dto.BusDto;
import com.obrs.travels.dto.OwnerDto;
import com.obrs.travels.dto.UserDto;
import com.obrs.travels.service.BusService;
import com.obrs.travels.service.OwnerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/travels/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private BusService busService;

	@GetMapping(path = "/login")
	public String displayLoginPage() {

		return "owner-login";
	}

	@PostMapping(path = "/login")
	public String verifyOwner(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {
		System.out.println("Username: " + username);
		System.out.println("Username: " + password);
		OwnerDto ownerDto = this.ownerService.findByuserNameAndPassword(username, password);

		if (ownerDto != null) {

			session.setAttribute("owner", ownerDto);

			return "owner-home";

		} else {

			return "worng-credentials";

		}

	}
	
	@GetMapping(path = "/home")
	public String home() {
		return "owner-home";
	}
	
	@GetMapping(path = "/signup")
	public String showOwnerRegisterPage() {
		return "owner-singup";
	}
	
	@PostMapping(path = "/signup")
	public String createNewOwner(@ModelAttribute OwnerDto ownerDto ) {
		System.out.println("ower name: " + ownerDto.getOwnerName());
		this.ownerService.createOwner(ownerDto);
		
		return "redirect:/travels/owner/login";
		
	}
	
	@GetMapping(path = "/bus/add/{id}")
	public String showAddBusPage(@PathVariable("id") Integer ownerId, HttpSession session) {
		
		OwnerDto owner = this.ownerService.getOwnerById(ownerId);
		System.out.println("owner name: " + owner.getOwnerName());
		session.setAttribute("owner", owner);
				
		return "owner-busAdd";
	}
	
	@PostMapping(path = "/bus/add/{id}")
	public String addNewbus(@ModelAttribute BusDto busDto, @PathVariable("id") Integer Id ) {
//		Integer ownerId = Integer.parseInt(Id);
		System.out.println("ID ; ===" + Id);
		System.out.println(busDto.getBoarding());
		this.busService.createBus(busDto, Id);
		return "owner-home";
		
	}
	
	@GetMapping(path = "/bus/{id}")
	public String viewBuses(@PathVariable("id") Integer id, Model model) {
		
		java.util.List<BusDto> buses = this.busService.getBusByOwnerId(id);
		
		model.addAttribute("BusList", buses);
		return "owner-bus";
	}

}
