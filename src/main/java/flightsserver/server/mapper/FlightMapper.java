package flightsserver.server.mapper;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.entity.Flight;

public class FlightMapper {
    public static FlightDto mapToFlightDto(Flight flight){
        return new FlightDto(
                flight.getFlightNumber(),
                flight.getAirline(),
                flight.getDepartureCity(),
                flight.getArrivalCity(),
                flight.getDepartureTime(),
                flight.getArrivalTime(),
                flight.getPrice(),
                flight.getSeats()
        );
    }

    public static Flight mapToFlight(FlightDto flightDto){
        return new Flight(
                flightDto.getFlightNumber(),
                flightDto.getAirline(),
                flightDto.getDepartureCity(),
                flightDto.getArrivalCity(),
                flightDto.getDepartureTime(),
                flightDto.getArrivalTime(),
                flightDto.getPrice(),
                flightDto.getSeats()
        );
    }
}
