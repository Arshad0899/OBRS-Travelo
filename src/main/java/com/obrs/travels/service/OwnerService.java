package com.obrs.travels.service;

import java.util.List;

import com.obrs.travels.dto.OwnerDto;

public interface OwnerService {

	OwnerDto createOwner(OwnerDto ownerDto);

	OwnerDto updateOwner(OwnerDto ownerDto, Integer ownerId);

	List<OwnerDto> getAllOwners();

	void deleteOwner(Integer ownerId);

	OwnerDto getOwnerById(Integer ownerId);
	
	OwnerDto findByuserNameAndPassword(String userName, String password);
	
//	List<OwnerDto> getOwnerByStatus(Boolean status);

}
