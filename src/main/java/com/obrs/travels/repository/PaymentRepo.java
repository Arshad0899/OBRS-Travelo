package com.obrs.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	
	
}
