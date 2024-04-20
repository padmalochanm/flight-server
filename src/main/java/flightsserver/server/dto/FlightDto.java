package flightsserver.server.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private String flightNumber;
    private String airline;
    private String departureCity;
    private String arrivalCity;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private long price;
    private int seats;
}
