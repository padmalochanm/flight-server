package flightsserver.server.service;

import flightsserver.server.dto.TicketDto;
import flightsserver.server.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    TicketDto createTicket(TicketDto ticketDto);
    List<Ticket> getTicketsByEmail(String email);
}
