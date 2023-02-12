package com.obrs.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmailAndPassword(String email, String password);

}
