package flightsserver.server.service;

import flightsserver.server.dto.FlightDto;

import java.util.List;

public interface FlightService {
    FlightDto getFlightByFlightNumber(String flightNumber);
    List<FlightDto> getFlights(String source, String destination);
}
