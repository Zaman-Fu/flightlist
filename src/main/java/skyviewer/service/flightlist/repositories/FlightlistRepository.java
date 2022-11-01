package skyviewer.service.flightlist.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import skyviewer.service.flightlist.entities.Flight;
import skyviewer.service.flightlist.util.IStringProperty;


public interface FlightlistRepository  extends JpaRepository<Flight,Long>{

	/*@Query(
			  value = "SELECT FLIGHT.ORIGIN  FROM FLIGHT GROUP BY FLIGHT.ORIGIN", 
			  nativeQuery = true)//this native query does not help us with aggregation...
			  
			 List<String> findAllOrigins(); */
	@Query(
			  value = "SELECT f.origin AS stringProperty FROM Flight as f GROUP BY f.origin")
	List<IStringProperty> findAllOrigins();

	@Query(
			  value = "SELECT f.destination AS stringProperty FROM Flight AS f WHERE f.origin = :origin GROUP BY f.destination" )
	List<IStringProperty> findDestinationsByOrigin(@Param("origin") String origin);

	@Query(
			  value = "SELECT * FROM BANK_ACCOUNT WHERE ORIGIN = :origin "
			  		+ "AND DESTINATION = :destination "
			  		+ "AND DEPARTURE_TIME > :first "
			  		+ "AND DEPARTURE_TIME < :last", 
			  nativeQuery = true)
	List<Flight> findByRouteAndDates(String origin, String destination, LocalDate first, LocalDate last);

	
}
