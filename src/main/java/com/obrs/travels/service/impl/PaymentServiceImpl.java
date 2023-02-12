package com.obrs.travels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.PaymentDto;
//import com.obrs.travels.dto.PaymentProcessDto;
import com.obrs.travels.models.Payment;
import com.obrs.travels.repository.PaymentRepo;
import com.obrs.travels.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private PaymentRepo paymentRepo;
//	
//	@Autowired
//	private PaymentProcessDto paymentProcessDto;

	@Override
	public void paymentProcess(PaymentDto paymentDto) {
		
		Payment payment = this.dtoToPayment(paymentDto);
		
		this.paymentRepo.save(payment);
		
	}

	private Payment dtoToPayment(PaymentDto dto) {
		
		Payment pay = new Payment();
		
		pay.setCardNo(dto.getCardNo());
		pay.setNameOncard(dto.getNameOncard());
		pay.setEmail(dto.getEmail());
		pay.setExpireDate(dto.getExpireDate());
		pay.setTotalPrice(dto.getTotalPrice());
		
		return pay;
	}
	
	
}
