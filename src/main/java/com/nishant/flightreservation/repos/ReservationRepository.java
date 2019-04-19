package com.nishant.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;



import com.nishant.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
