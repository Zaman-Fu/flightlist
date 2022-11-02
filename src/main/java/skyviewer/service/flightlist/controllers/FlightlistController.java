package skyviewer.service.flightlist.controllers;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.services.FlightlistService;

@RestController
public class FlightlistController {
	
	@Autowired
	FlightlistService service;
	
	
	@GetMapping("flights/origins") //localhost:8081/flights/origins/
	public ResponseEntity<List<String>> GetOrigins(){
		List<String> origins= service.getAllOrigins();
		
		if(origins==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(origins,HttpStatus.OK);
	}
	
	@GetMapping("flights/origins/{origin}") //localhost:8081/flights/origins/seville
	public ResponseEntity<List<String>> GetDestinationsByOrigin(@PathVariable String origin) {
		List<String> destinations=service.findDestinationsByOrigin(origin);
		
		if(destinations==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(destinations,HttpStatus.OK);
	}
	
	
	
	@GetMapping("flights/search")
	public ResponseEntity<List<Flight>> GetFlightsByRouteAndDate(@RequestBody Flight searchParams)//Send an incomplete flight object then use service logic
	{
		
		List<Flight> flights=service.findFlightsByRouteAndDate(searchParams);
		
		if(flights==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(flights,HttpStatus.OK);
		
	}
	
	@GetMapping("test/flights")
	public ResponseEntity<List<Flight>> GetAllFlights()
	{
		List<Flight> flights=service.findAllFlights();
		
		if(flights==null)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(flights,HttpStatus.OK);
	}

}
