package com.obrs.travels.service;

import java.util.List;

import com.obrs.travels.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);

	UserDto findByUsernameAndPassword(String username, String password);

}
