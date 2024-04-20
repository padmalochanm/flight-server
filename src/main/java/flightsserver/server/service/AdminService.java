package flightsserver.server.service;

import flightsserver.server.dto.FlightDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {
    FlightDto createFlight(FlightDto flightDto);
    Page<FlightDto> getAllFlights(int page);
    FlightDto updateFlight(String flightNumber, FlightDto updatedFlight);
    void deleteFlight(String flightNumber);
}
