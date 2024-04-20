package flightsserver.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "flightNumber")
    private String flightNumber;

    @Column(name = "airline")
    private String airline;

    @Column(name = "departureCity")
    private String departureCity;

    @Column(name = "arrivalCity")
    private String arrivalCity;

    @Column(name = "departureTime")
    private LocalTime departureTime;

    @Column(name = "arrivalTime")
    private LocalTime arrivalTime;

    @Column(name = "price")
    private long price;

    @Column(name = "seats")
    private int seats;

}

