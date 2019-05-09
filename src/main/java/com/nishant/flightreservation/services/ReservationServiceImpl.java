package com.nishant.flightreservation.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nishant.flightreservation.dto.ReservationRequest;
import com.nishant.flightreservation.entities.Flight;
import com.nishant.flightreservation.entities.Passenger;
import com.nishant.flightreservation.entities.Reservation;
import com.nishant.flightreservation.repos.FlightRepository;
import com.nishant.flightreservation.repos.PassengerRepository;
import com.nishant.flightreservation.repos.ReservationRepository;
import com.nishant.flightreservation.util.EmailUtil;
import com.nishant.flightreservation.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()");
		
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching flights for Id: "+flightId);
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		LOGGER.info("Saving the passenger:"+passenger);
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("Saving the reservation:"+reservation);
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:/Users/nisha/OneDrive/Documents/Reservations/reservation"+savedReservation.getId()+".pdf";
		
		LOGGER.info("Generating the Itinerary:");
		
		pdfGenerator.generateItinerary(savedReservation, filePath);
		
		LOGGER.info("Emailing the Itinerary:");
		
		emailUtil.sendItinerary(passenger.getEmail(),filePath );
		
		return savedReservation;
	}

}
