package com.obrs.travels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obrs.travels.dto.PaymentDto;
import com.obrs.travels.service.PaymentService;

@Controller
@RequestMapping(path = "/travels/user/booking/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(path = "/")
	public String paymentCompletion(@ModelAttribute PaymentDto paymentDto) {
		
		this.paymentService.paymentProcess(paymentDto);
		
		return "payment-success";
	}

}
