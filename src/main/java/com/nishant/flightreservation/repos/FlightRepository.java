package com.nishant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nishant.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
