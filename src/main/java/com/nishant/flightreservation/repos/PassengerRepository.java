package com.nishant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nishant.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
