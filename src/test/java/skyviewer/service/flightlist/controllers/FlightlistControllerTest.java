package skyviewer.service.flightlist.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;

import skyviewer.service.flightlist.services.FlightlistService;

class FlightlistControllerTest {
	
	FlightlistService service;
	FlightlistController controller = new FlightlistController();

	@Test
	void GetOrigins_WhenCalled_ListofOriginsReturned() {
		List<String> origins= (List<String>) controller.GetOrigins();
		assertFalse(origins.isEmpty());
	}
	@Test
	void GetDestinationsFromOrigin_OriginIsAthens_PossibleDestinationsReturned() {
		
	}
	@Test
	void GetFlightsByRouteAndDate_FlightAreAvailable_ListOfFlightsIsReturned() {
		
	}
	@Test
	void GetFlightsByRouteAndDate_FlightAreNotAvailable_EmptyListIsReturned() {
		
	}

}
