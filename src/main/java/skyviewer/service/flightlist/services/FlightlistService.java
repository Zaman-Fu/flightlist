package skyviewer.service.flightlist.services;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.repositories.FlightlistRepository;
import skyviewer.service.flightlist.util.IStringProperty;

@Service
public class FlightlistService {

	@Autowired
	FlightlistRepository repository;


	public List<String> getAllOrigins() {
		// TODO Auto-generated method stub
		System.out.println("Service layer called to get all origins");
		List<IStringProperty> origins=repository.findAllOrigins();
		List<String> originsString=new ArrayList<String>();
		for(int i=0;i<origins.size();i++)
		{
			originsString.add(origins.get(i).getStringProperty());
		}
		return originsString;
		//return repository.findAllOrigins();
	}

	public List<String> findDestinationsByOrigin(String origin) {
		
		List<IStringProperty> destinations=repository.findDestinationsByOrigin(origin);
		List<String> destinationsString=new ArrayList<String>();
		
		for(int i=0;i<destinations.size();i++)
		{
			destinationsString.add(destinations.get(i).getStringProperty());
		}
		return destinationsString;
		//return repository.findDestinationsByOrigin(origin);
	}
	
	public List<Flight> findAllFlights() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public List<Flight> findFlightsByRouteAndDate(Flight params) {
		// TODO Auto-generated method stub
		Pair<LocalDate,LocalDate> dateRange=DateRange(params.getDate());
		return repository.findByRouteAndDates(params.getOrigin(), params.getDestination(), dateRange.getFirst(), dateRange.getSecond());
	}
	
	
	///The logic deciding on the date range for picking flights
	private Pair<LocalDate,LocalDate> DateRange(LocalDate targetDate)
	{
		Long dayDiff=Duration.between(targetDate, LocalDate.now()).toDays();
		if(dayDiff<3)
		{
		    return Pair.of(targetDate.minusDays(dayDiff), targetDate.plusDays(4));
		}
		
		return Pair.of(targetDate.minusDays(3),targetDate.plusDays(3));
	}

	
	
	
	
	
}
