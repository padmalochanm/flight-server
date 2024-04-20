package flightsserver.server.mapper;
import flightsserver.server.dto.TicketDto;
import flightsserver.server.entity.Ticket;

public class TicketMapper {
    public static TicketDto mapToTicketDto(Ticket ticket){
        return new TicketDto(
                ticket.getId(),
                ticket.getFlightNumber(),
                ticket.getEmail(),
                ticket.getSeats(),
                ticket.getCost()
        );
    }

    public static Ticket mapToTicket(TicketDto ticketDto){
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getFlightNumber(),
                ticketDto.getEmail(),
                ticketDto.getSeats(),
                ticketDto.getCost()
        );
    }

}
