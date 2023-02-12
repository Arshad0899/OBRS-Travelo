package com.obrs.travels.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.AdminDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.Admin;
import com.obrs.travels.repository.AdminRepo;
import com.obrs.travels.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public AdminDto getUserById(Integer adminId) {
		Admin admin = this.adminRepo.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
		return this.adminToDto(admin);
	}

	@Override
	public AdminDto updateUser(AdminDto adminDto, Integer adminId) {

		Optional<Admin> optionalAdmin = this.adminRepo.findById(adminId);

		Admin admin = optionalAdmin.get();

		if (optionalAdmin.isPresent()) {
			admin.setFirstName(adminDto.getFirstName());
			admin.setLastName(adminDto.getLastName());
			admin.setPassword(adminDto.getPassword());
			admin.setPhoneNo(adminDto.getPhoneNo());
			admin.setEmail(adminDto.getEmail());

			Admin updateAdmin = this.adminRepo.save(admin);

			return this.adminToDto(updateAdmin);

		} else {

			return null;

		}

	}

	@Override
	public AdminDto findByEmailAndPassword(String email, String password) {

		Admin admin = null;

		admin = this.adminRepo.findByEmailAndPassword(email, password);

		return this.adminToDto(admin);
	}

	private Admin dtoToAdmin(AdminDto dto) {

		Admin admin = new Admin();

		admin.setAdminId(dto.getAdminId());
		admin.setFirstName(dto.getFirstName());
		admin.setLastName(dto.getLastName());
		admin.setPassword(dto.getPassword());
		admin.setPhoneNo(dto.getPhoneNo());
		admin.setEmail(dto.getEmail());

		return admin;
	}

	private AdminDto adminToDto(Admin admin) {

		AdminDto dto = new AdminDto();

		dto.setAdmin_id(admin.getAdminId());
		dto.setFirstName(admin.getFirstName());
		dto.setLastName(admin.getLastName());
		dto.setPassword(admin.getPassword());
		dto.setPhoneNo(admin.getPhoneNo());
		dto.setEmail(admin.getEmail());

		return dto;
	}

}
