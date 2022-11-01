package skyviewer.service.flightlist.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.repositories.FlightlistRepository;

@Service
public class FlightlistService {

	@Autowired
	FlightlistRepository repository;


	public List<String> getAllOrigins() {
		// TODO Auto-generated method stub
		return repository.findAllOrigins();
	}

	public List<String> findDestinationsByOrigin(String origin) {
		// TODO Auto-generated method stub
		return repository.findDestinationsByOrigin(origin);
	}

	public List<Flight> findFlightsByRouteAndDate(Flight params) {
		// TODO Auto-generated method stub
		Pair<LocalDate,LocalDate> dateRange=DateRange(params.getDate());
		return repository.findByRouteAndDates(params.getOrigin(), params.getDestination(), dateRange.getFirst(), dateRange.getSecond());
	}
	
	
	///The logic deciding on the date range for picking flights
	private Pair<LocalDate,LocalDate> DateRange(LocalDate targetDate)
	{
		
		return Pair.of(targetDate.minusDays(3),targetDate.plusDays(3));
	}
	
	
	
	
}
