package flightsserver.server.controller;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private FlightService flightService;

    @GetMapping("{flightNumber}")
   public ResponseEntity<FlightDto>getFlightByFlightNumber(@PathVariable("flightNumber") String flightNumber){
        FlightDto flightDto = flightService.getFlightByFlightNumber(flightNumber);
        return ResponseEntity.ok(flightDto);
   }

   @GetMapping
   public ResponseEntity<List<FlightDto>> getFlights(@RequestParam String source, @RequestParam String destination){
        List<FlightDto> flights = flightService.getFlights(source, destination);
        return ResponseEntity.ok(flights);
   }
}
