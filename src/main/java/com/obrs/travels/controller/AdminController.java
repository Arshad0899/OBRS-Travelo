package com.obrs.travels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

import com.obrs.travels.dto.AdminDto;
import com.obrs.travels.dto.AdminLoginDto;
import com.obrs.travels.dto.BusDto;
import com.obrs.travels.dto.OwnerDto;
import com.obrs.travels.service.AdminService;
import com.obrs.travels.service.BusService;
import com.obrs.travels.service.OwnerService;

@Controller
@RequestMapping(path = "/travels/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private BusService busService;

	@Autowired
	private OwnerService ownerService;

	// Returns Admin Login page
	@GetMapping("/login")
	public String loginAdmin() {
		return "admin-login";
	}

	@GetMapping("/logout")
	public String logoutAdmin() {
		return "redirect:/travels";
	}
	
//	@GetMapping(path= "/")

	// Get and verify login credentials
	@PostMapping(path = "/login")
	public String login(@ModelAttribute AdminLoginDto adminLoginDto, HttpSession session) {
		System.err.println("password: --- " + adminLoginDto.getPassword());
		AdminDto adminDto = this.adminService.findByEmailAndPassword(adminLoginDto.getEmail(),
				adminLoginDto.getPassword());

		Boolean token = false;
		if (adminDto == null) {
			token = true;
		}
		session.setAttribute("tlk", token);
		return "admin-home";
	}

	// Returns Admin home page
	@GetMapping(path = "/")
	public String displayAdminHomePage() {
		return "admin-home";
	}

	@GetMapping(path = "/update/{id}")
	public String displayAdminUpdatePage(@PathVariable("id") Integer adminId) {
		return "admin-update";
	}

	@GetMapping(path = "/bus")
	public String showManageBusPage(Model model) {
		List<BusDto> buses = this.busService.getAllBus();
		model.addAttribute("BusList", buses);
		return "manage-bus";
	}

	@GetMapping(path = "/bus/delete/{id}")
	public String deleteBusById(@PathVariable("id") Integer id) {
		this.busService.deleteBus(id);
		return "redirect:/travels/admin/bus";
	}

	// Owner need to do
	@GetMapping(path = "/owner")
	public String showManageOwnerPage(Model model) {
		List<OwnerDto> owners = this.ownerService.getAllOwners();
		model.addAttribute("OwnerList", owners);
		return "manage-owners";
	}

	@GetMapping(path = "/owner/delete/{id}")
	public String deleteOwnerById(@PathVariable("id") Integer id) {
		this.ownerService.deleteOwner(id);
		return "redirect:/travels/admin/owner";
	}

	@GetMapping(path = "/bus/approve")
	public String showManageApprove(Model model, HttpSession session) {
		List<BusDto> buses = this.busService.getBusByIsApproved(false);
		Boolean token = buses.isEmpty();
		session.setAttribute("token", token);
		model.addAttribute("BusList", buses);
		return "approve-page";
	}

	@GetMapping(path = "/bus/approve/{id}")
	private String adminApprovedBus(@PathVariable("id") Integer busId) {

		this.busService.approveBusById(busId);

		return "redirect:/travels/admin/bus/approve";
	}

	@GetMapping(path = "/bus/deney/{id}")
	private String adminDeneyBus(@PathVariable("id") Integer busId) {

		this.busService.deleteBus(busId);

		return "redirect:/travels/admin/bus/approve";

	}

	
	@GetMapping(path = "/travels/admin/no-data")
	public String error() {
		return "worng-credentials";
	}
	
	////// NO NEED IN ADMIN MODULE CAN BE USEFUL IN OTHER MODULES DON'T DELETE
	////// ///////

	// View all users
//	@GetMapping(path = "/user")
//	public String showManageUsersPage(Model model) {
//		List<UserDto> users = userService.getAllUsers();
//		model.addAttribute("usersList", users);
//		return "manage-users";
//	}

	// Show User Page
//	@GetMapping(path = "/user/add")
//	public String addUserPage() {
//
//		return "addUser";
//	}

	// Add User into DB
//	@PostMapping(path = "/user/add")
//	public String createUser(@ModelAttribute UserDto userDto) {
//		this.userService.createUser(userDto);
//
//		return "redirect:/travels/admin/user";
//	}

//	@GetMapping("/user/delete/{id}")
//	public String deleteUser(@PathVariable("id") Integer userId) {
//		this.userService.deleteUser(userId);
//
//		return "redirect:/travels/admin/user";
//	}

//	@GetMapping("/user/update/{userId}")
//	public String showUpdateUserPage(@PathVariable("userId") Integer id, Model model) {
//
//		UserDto user = this.userService.getUserById(id);
//
//		if (user != null) {
//			model.addAttribute("user", user);
//			return "update-user";
//		} else {
//			return "redirect:/travels/admin/user";
//		}
//
//	}

//	@PostMapping("/user/update")
//	public String updateUser(@ModelAttribute UserDto userDto) {
//		this.userService.updateUser(userDto, userDto.getUserId());
//		return "redirect:/travels/admin/user";
//	}

}
