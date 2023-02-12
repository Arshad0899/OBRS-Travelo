package com.obrs.travels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obrs.travels.dto.AdminDto;
import com.obrs.travels.dto.BusDto;
import com.obrs.travels.dto.UserDto;
import com.obrs.travels.dto.UserLoginDto;
import com.obrs.travels.service.BusService;
import com.obrs.travels.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/travels/user")
public class UserController {

	@Autowired
	private BusService busService;
	
	@Autowired
	private UserService userService;

	@GetMapping(path = "/")
	public String displayUserLogin() {

		return "user-login";
	}

	@PostMapping(path = "/login")
	public String loginUser(@ModelAttribute UserLoginDto userLoginDto, HttpSession session, Model model) {	
		
		UserDto userDto = this.userService.findByUsernameAndPassword(userLoginDto.getUserName(), userLoginDto.getPassword());

		session.setAttribute("user", userDto);
		return "user-home";
	}
	
	@GetMapping(path = "/home")
	public String homepage() {
		return "user-home";
	}
	
	@GetMapping(path = "/logout")
	public String logoutuser() {
		return "redirect:/travels";
	}
	
//	@GetMapping(path = "/")
//	public String showUserHomePage() {
//		return "user-home";
//	}

	@PostMapping(path = "/bus-available")
	public String showAvalableBus(@RequestParam Integer userId, @ModelAttribute BusDto busDto, Model model, HttpSession session) {
		List<BusDto> buses = this.busService.getBusByBoardingAndDestinationAndJourneyDateAndIsApproved(busDto.getBoarding(),
				busDto.getDestination(), busDto.getJourneyDate(), true);
		boolean token = buses.isEmpty();
		session.setAttribute("token", token);
		String userNo = Integer.toString(userId);
		model.addAttribute("userId", userNo);
		model.addAttribute("busList", buses);
		return "bus-available";
	}
	
	@GetMapping(path = "/no-bus-available")
	public String showNoBusFoundError() {
		return "no-bus-available";
	}
	
	@GetMapping(path = "/signup")
	public String showUserSignUpPage() {
		return "user-signUp";
	}
	
	@PostMapping(path = "/signup")
	public String saveUserDetails(@ModelAttribute UserDto userDto) {
		this.userService.createUser(userDto);
		return "redirect:/travels/user/";
	}
	

}
