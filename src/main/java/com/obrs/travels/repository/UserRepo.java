package com.obrs.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUserNameAndPassword(String userName, String password);
	
}