package skyviewer.service.flightlist.util;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.repositories.FlightlistRepository;


@Component
public class PopulateFlightsCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	FlightlistRepository flightRepository;
	//We're doing this to have a table of users and accounts to play with in the app :)
	@Override
	public void run(String... args) throws Exception {

		flightRepository.save(new Flight(1l,"Seville","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,900f,false));
		flightRepository.save(new Flight(2l,"Madrid","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,950f,false));
		flightRepository.save(new Flight(3l,"London","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,800f,false));
		flightRepository.save(new Flight(4l,"Amsterdam","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,980f,true));
		flightRepository.save(new Flight(5l,"Paris","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,900f,false));
	}
}
