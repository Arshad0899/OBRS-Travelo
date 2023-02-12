package com.obrs.travels.service;

import com.obrs.travels.dto.AdminDto;

public interface AdminService {
	
	// AdminDto createAdmin(AdminDto adminDto);
	
	AdminDto getUserById(Integer adminId);
	
	AdminDto updateUser(AdminDto adminDto, Integer adminId);
	
	// List<AdminDto> getAllAdmins();
	
	// void deleteAdmin(Integer userId);
	
	AdminDto findByEmailAndPassword(String email, String password);
	
	
	

}
