package skyviewer.service.flightlist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import skyviewer.service.flightlist.entities.Flight;

public interface FlightlistRepository  extends JpaRepository<Flight,Long>{

	@Query(
			  value = "SELECT ORGIN FROM FLIGHT GROUP BY ORIGIN", 
			  nativeQuery = true)
	List<String> findAllOrigins();

	@Query(
			  value = "SELECT DESTINATION FROM FLIGHT WHERE ORIGIN = :origin GROUP BY ORIGIN" , 
			  nativeQuery = true)
	List<String> findDestinationsByOrigin(String origin);

	@Query(
			  value = "SELECT * FROM BANK_ACCOUNT WHERE ORIGIN = :origin "
			  		+ "AND DESTINATION = :destination "
			  		+ "AND DEPARTURE_TIME > :first "
			  		+ "AND DEPARTURE_TIME < :last", 
			  nativeQuery = true)
	List<Flight> findByRouteAndDates(String origin, String destination, LocalDate first, LocalDate last);

	
}
