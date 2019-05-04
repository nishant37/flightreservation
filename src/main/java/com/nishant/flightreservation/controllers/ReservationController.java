package com.nishant.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nishant.flightreservation.entities.Flight;
import com.nishant.flightreservation.repos.FlightRepository;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
    @RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId) {
    	Flight flight = flightRepository.findById(flightId).get();
		return "completeReservation";
	}
	
}
