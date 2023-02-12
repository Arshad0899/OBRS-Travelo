package com.obrs.travels.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.OwnerDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.Owner;
import com.obrs.travels.models.User;
import com.obrs.travels.repository.OwnerRepo;
import com.obrs.travels.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepo ownerRepo;

	@Override
	public OwnerDto createOwner(OwnerDto ownerDto) {

		Owner owner = this.dtoToOwner(ownerDto);

		Owner savedOwner = this.ownerRepo.save(owner);

		return this.ownerToDto(savedOwner);
	}

	@Override
	public OwnerDto updateOwner(OwnerDto ownerDto, Integer ownerId) {

		Optional<Owner> optionalOwner = this.ownerRepo.findById(ownerId);

		Owner owner = optionalOwner.get();

		if (optionalOwner.isPresent()) {
			owner.setOwnerName(ownerDto.getOwnerName());
			owner.setUserName(ownerDto.getUsername());
			owner.setAddress(ownerDto.getAddress());
			owner.setEmailId(ownerDto.getEmailId());
			owner.setPassword(ownerDto.getPassword());

			Owner updateOwner = this.ownerRepo.save(owner);

			return this.ownerToDto(updateOwner);

		} else {

			return null;

		}

	}

	@Override
	public OwnerDto findByuserNameAndPassword(String userName, String password) {

		Owner owner = null;

		owner = this.ownerRepo.findByUserNameAndPassword(userName, password);

		return this.ownerToDto(owner);
	}

	@Override
	public List<OwnerDto> getAllOwners() {

		List<Owner> owners = this.ownerRepo.findAll();

		List<OwnerDto> ownerDtos = owners.stream().map(Owner -> this.ownerToDto(Owner)).collect(Collectors.toList());

		return ownerDtos;
	}

	@Override
	public void deleteOwner(Integer ownerId) {

		Owner owner = this.ownerRepo.findById(ownerId)
				.orElseThrow(() -> new ResourceNotFoundException("Owner", "id", ownerId));
		
		this.ownerRepo.delete(owner);
	}

//	@Override
//	public List<OwnerDto> getOwnerByStatus(Boolean status) {
//
//		List<Owner> owners = this.ownerRepo.findByStatus(status);
//
//		if (owners != null) {
//
//			List<OwnerDto> ownerDtos = owners.stream().map(Owner -> this.ownerToDto(Owner))
//					.collect(Collectors.toList());
//			
//			return ownerDtos;
//
//		} else {
//
//			return null;
//
//		}
//
//	}

	@Override
	public OwnerDto getOwnerById(Integer ownerId) {

		Optional<Owner> optionalOwner = this.ownerRepo.findById(ownerId);

		Owner owner = optionalOwner.get();

		if (optionalOwner.isPresent()) {

			return this.ownerToDto(owner);
		} else {

			return null;

		}

	}

	private Owner dtoToOwner(OwnerDto dto) {

		Owner owner = new Owner();
		owner.setOwnerId(dto.getOwnerId());
		owner.setOwnerName(dto.getOwnerName());
		owner.setUserName(dto.getUsername());
		owner.setAddress(dto.getAddress());
		owner.setEmailId(dto.getEmailId());
		owner.setPassword(dto.getPassword());

		return owner;

	}

	private OwnerDto ownerToDto(Owner owner) {

		OwnerDto dto = new OwnerDto();
		dto.setOwnerId(owner.getOwnerId());
		dto.setOwnerName(owner.getOwnerName());
		dto.setUsername(owner.getUserName());
		dto.setAddress(owner.getAddress());
		dto.setEmailId(owner.getEmailId());
		dto.setPassword(owner.getPassword());

		return dto;

	}

}
