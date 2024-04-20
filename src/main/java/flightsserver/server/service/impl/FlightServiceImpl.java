package flightsserver.server.service.impl;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.entity.Flight;
import flightsserver.server.exception.ResourceNotFound;
import flightsserver.server.mapper.FlightMapper;
import flightsserver.server.repository.FlightRepository;
import flightsserver.server.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    FlightRepository flightRepository;
    @Override
    public FlightDto getFlightByFlightNumber(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber)
                .orElseThrow(() -> new ResourceNotFound("No flight exists with number: " + flightNumber));
        return FlightMapper.mapToFlightDto(flight);
    }

    @Override
    public List<FlightDto> getFlights(String source, String destination) {
        List<Flight> flights = flightRepository.findByDepartureCityAndArrivalCity(source, destination);
        return flights.stream().map((flight) -> FlightMapper.mapToFlightDto(flight)).collect(Collectors.toList());
    }
}
