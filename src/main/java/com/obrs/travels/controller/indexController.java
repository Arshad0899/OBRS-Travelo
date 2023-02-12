package com.obrs.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.obrs.travels.dto.UserDto;
import com.obrs.travels.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class indexController {

	@Autowired
	private UserService user;

	@GetMapping("/travels")
	public String myIndex() {

		return "index";

	}

	@PostMapping(path = "/travels")
	public String login(@RequestParam String username, @RequestParam String password, Model model,
			HttpSession session) {

		UserDto userDto = this.user.findByUsernameAndPassword(username, password);
		
		if (userDto != null) {

			session.setAttribute("user", userDto);
//			System.out.println(userDto.getUserName());

			return "redirect:/travels/user/";

		} else {

			return "redirect:/travels/worng-credentials";

		}

	}

	@GetMapping(path = "/travels/signup")
	public String userSignup() {
		return "addUser";
	}

}
