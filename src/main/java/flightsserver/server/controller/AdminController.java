package flightsserver.server.controller;

import flightsserver.server.dto.FlightDto;
import flightsserver.server.repository.FlightRepository;
import flightsserver.server.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private AdminService adminService;
    private FlightRepository flightRepository;

    @PostMapping
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto){
        FlightDto savedFlight = adminService.createFlight(flightDto);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @GetMapping("{page}")
    public ResponseEntity<Page<FlightDto>> getAllFlights(@PathVariable("page") int page ){
        Page<FlightDto> flights = adminService.getAllFlights(page);
        return ResponseEntity.ok(flights);
    }

    @PutMapping("{flightNumber}")
    public ResponseEntity<FlightDto>updateFlight(@PathVariable("flightNumber") String flightNumber, @RequestBody FlightDto updatedFlight){
        FlightDto flightDto = adminService.updateFlight(flightNumber, updatedFlight);
        return ResponseEntity.ok(flightDto);
    }

    @DeleteMapping("{flightNumber}")
    public ResponseEntity<String>deleteFlight(@PathVariable("flightNumber") String flightNumber){
        adminService.deleteFlight(flightNumber);
        return ResponseEntity.ok("Flight deleted successfully");
    }
}
