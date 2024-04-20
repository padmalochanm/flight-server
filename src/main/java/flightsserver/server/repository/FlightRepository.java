package flightsserver.server.repository;

import flightsserver.server.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByDepartureCityAndArrivalCity(
            String departureCity,
            String arrivalCity
    );
}
