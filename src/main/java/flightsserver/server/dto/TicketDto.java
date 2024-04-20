package flightsserver.server.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {
    private Integer id;
    private String flightNumber;
    private String email;
    private int seats;
    private Long cost;
}
