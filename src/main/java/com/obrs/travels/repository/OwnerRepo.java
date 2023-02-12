package com.obrs.travels.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Integer> {

	public Owner findByUserNameAndPassword(String userName, String password);

}
