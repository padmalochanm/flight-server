package flightsserver.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flightNumber")
    private String flightNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "seats")
    private int seats;

    @Column(name = "cost")
    private Long cost;

}
