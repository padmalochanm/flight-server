package flightsserver.server.controller;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.dto.TicketDto;
import flightsserver.server.entity.Flight;
import flightsserver.server.entity.Ticket;
import flightsserver.server.mapper.FlightMapper;
import flightsserver.server.repository.FlightRepository;
import flightsserver.server.service.FlightService;
import flightsserver.server.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    TicketService ticketService;
    FlightRepository flightRepository;
    FlightService flightService;
    @GetMapping("{email}")
    public ResponseEntity<List<Ticket>> getFlightByFlightNumber(@PathVariable("email") String email){
        List<Ticket> ticket = ticketService.getTicketsByEmail(email);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto){
        TicketDto savedTicket = ticketService.createTicket(ticketDto);
        FlightDto flightDto = flightService.getFlightByFlightNumber(ticketDto.getFlightNumber());
        Flight flight = FlightMapper.mapToFlight(flightDto);
        if(flightDto.getSeats() - ticketDto.getSeats() >=0){
            flight.setSeats(flightDto.getSeats() - ticketDto.getSeats());
            flightRepository.save(flight);
            return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

}
