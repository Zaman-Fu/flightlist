package skyviewer.service.flightlist.util;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import skyviewer.service.flightlist.entities.AdminUser;
import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.repositories.AdminUserRepository;
import skyviewer.service.flightlist.repositories.FlightlistRepository;


@Component
public class PopulateFlightsCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	FlightlistRepository flightRepository;
	
	@Autowired
	AdminUserRepository userRepository;
	//We're doing this to have a table of users and accounts to play with in the app 
	@Override
	public void run(String... args) throws Exception {

		flightRepository.save(new Flight(1l,"Seville","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),1,true,900f,false));
		flightRepository.save(new Flight(2l,"Madrid","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 40),1,true,950f,false));
		flightRepository.save(new Flight(3l,"London","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(9, 20),0,true,800f,false));
		flightRepository.save(new Flight(4l,"Amsterdam","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(11, 20),0,true,980f,true));
		flightRepository.save(new Flight(5l,"Paris","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,900f,false));
		flightRepository.save(new Flight(6l,"Paris","New York",LocalDate.of(2022,11,12),LocalTime.of(11, 30),LocalTime.of(10, 20),0,true,900f,false));
		flightRepository.save(new Flight(7l,"Seville","Paris",LocalDate.of(2022,11,11),LocalTime.of(11, 30),LocalTime.of(2, 20),0,true,250.5f,true));
		flightRepository.save(new Flight(8l,"Paris","Seville",LocalDate.of(2022,11,15),LocalTime.of(11, 30),LocalTime.of(2, 20),0,true,250f,false));
		flightRepository.save(new Flight(9l,"Seville","Madrid",LocalDate.of(2022,11,12),LocalTime.of(6, 30),LocalTime.of(0, 45),0,false,100f,true));
		flightRepository.save(new Flight(10l,"Seville","Madrid",LocalDate.of(2022,11,12),LocalTime.of(6, 30),LocalTime.of(0, 45),0,false,100f,true));
		
		
		
		userRepository.save(new AdminUser(1l,"Administrator","Admin","User","guest"));
		userRepository.save(new AdminUser(2l,"Jonpad","John","Papadopoulos","paok"));
		

	}
}
