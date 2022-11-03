package skyviewer.service.flightlist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import skyviewer.service.flightlist.controllers.FlightlistController;
import skyviewer.service.flightlist.entities.Flight;


@SpringBootTest
class FlightlistApplicationTests {

	@Autowired
	private FlightlistController controller ;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void GetAllFlights_ReturnsOK()
	{
		ResponseEntity<List<Flight>> response=controller.GetAllFlights();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void GetAllOrigins_NotNull_ReturnsOK()
	{
		ResponseEntity<List<String>> response=controller.GetOrigins();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void GetAllDestinationsByOrigin_ReturnsOK()
	{
		//It´s a dummy flight object. All that matters are the search params we´ll be claiming off of it
		Flight mockFlight=new Flight(0l,"Paris","New York",LocalDate.of(2022,11,10),LocalTime.of(12, 30),LocalTime.of(10, 20),0,true,900f,false);
		
		ResponseEntity<List<Flight>> response=controller.GetFlightsByRouteAndDate(mockFlight);
		
	}
	
	
	@Test
	void GetAllDestinationsByParams_NotNull_ReturnsOK()
	{
		
	}
	
	
	
	
	

}
