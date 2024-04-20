package flightsserver.server.service.impl;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.entity.Flight;
import flightsserver.server.exception.ResourceNotFound;
import flightsserver.server.mapper.FlightMapper;
import flightsserver.server.repository.FlightRepository;
import flightsserver.server.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private FlightRepository flightRepository;
    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        Flight flight = FlightMapper.mapToFlight(flightDto);
        Flight savedFlight = flightRepository.save(flight);
        return FlightMapper.mapToFlightDto(savedFlight);
    }

    @Override
    public Page<FlightDto> getAllFlights(int page) {
        Page<Flight> flights = flightRepository.findAll(PageRequest.of(page, 4));
        return flights.map(FlightMapper::mapToFlightDto);
    }


    @Override
    public FlightDto updateFlight(String flightNumber, FlightDto updatedFlight) {
        Flight flight = flightRepository.findById(flightNumber).orElseThrow(()-> new ResourceNotFound("This flight doesn't exist."));
        flight.setPrice(updatedFlight.getPrice());
        Flight updatedFLightObj = flightRepository.save(flight);
        return FlightMapper.mapToFlightDto(updatedFLightObj);
    }

    @Override
    public void deleteFlight(String flightNumber) {
        Flight flight = flightRepository.findById(flightNumber).orElseThrow(()-> new ResourceNotFound("This flight doesn't exist."));
        flightRepository.deleteById(flightNumber);
    }
}
