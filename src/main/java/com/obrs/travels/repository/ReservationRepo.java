package com.obrs.travels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obrs.travels.models.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
