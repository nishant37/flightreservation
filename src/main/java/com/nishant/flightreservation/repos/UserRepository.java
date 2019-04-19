package com.nishant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
