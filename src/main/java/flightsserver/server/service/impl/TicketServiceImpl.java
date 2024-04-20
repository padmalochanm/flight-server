package flightsserver.server.service.impl;

import flightsserver.server.dto.TicketDto;
import flightsserver.server.entity.Ticket;
import flightsserver.server.mapper.TicketMapper;
import flightsserver.server.repository.TicketRepository;
import flightsserver.server.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    @Override
    public TicketDto createTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToTicket(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.mapToTicketDto(savedTicket);
    }

    @Override
    public List<Ticket> getTicketsByEmail(String email) {
        List<Ticket> ticket = ticketRepository.findByEmail(email);
        return ticket;
    }
}
