package com.nishant.flightreservation.services;

import com.nishant.flightreservation.dto.ReservationRequest;
import com.nishant.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
	

}
