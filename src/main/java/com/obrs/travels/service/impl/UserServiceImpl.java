package com.obrs.travels.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrs.travels.dto.UserDto;
import com.obrs.travels.exception.ResourceNotFoundException;
import com.obrs.travels.models.User;
import com.obrs.travels.repository.UserRepo;
import com.obrs.travels.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		
		User savedUser = this.userRepo.save(user);

		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		Optional<User> optionalUser = this.userRepo.findById(userId);
		
		User user = optionalUser.get();
		
		if(optionalUser.isPresent()) {
			user.setUserName(userDto.getUserName());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setPassword(userDto.getPassword());
			user.setEmail(userDto.getEmail());
			user.setPhoneNo(userDto.getPhoneNo());
			
			User updateUser = this.userRepo.save(user);
			
			return this.userToDto(updateUser);

		} else {
			
			return null;
			
		}

	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(User -> this.userToDto(User)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		
		this.userRepo.delete(user);

	}

	@Override
	public UserDto findByUsernameAndPassword(String username, String password) {
		
		User user = this.userRepo.findByUserNameAndPassword(username, password);
		
		return this.userToDto(user);
	}

	private User dtoToUser(UserDto dto) {
		
		User user = new User();

		user.setUserId(dto.getUserId());
		user.setUserName(dto.getUserName());
		user.setFirstName(dto.getFirstName());
		user.setAge(dto.getAge());
		user.setLastName(dto.getLastName());
		user.setPassword(dto.getPassword());
		user.setGender(dto.getGender());
		user.setEmail(dto.getEmail());
		user.setPhoneNo(dto.getPhoneNo());

		return user;
	}

	private UserDto userToDto(User user) {

		UserDto dto = new UserDto();

		dto.setUserId(user.getUserId());
		dto.setUserName(user.getUserName());
		dto.setFirstName(user.getFirstName());
		dto.setAge(user.getAge());
		dto.setLastName(user.getLastName());
		dto.setPassword(user.getPassword());
		dto.setGender(user.getGender());
		dto.setEmail(user.getEmail());
		dto.setPhoneNo(user.getPhoneNo());

		return dto;
	}


}
