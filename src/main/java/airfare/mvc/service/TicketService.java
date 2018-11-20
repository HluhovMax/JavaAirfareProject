package airfare.mvc.service;

import airfare.mvc.dao.TicketRepository;
import airfare.mvc.model.Ticket;

public class TicketService {
    private TicketRepository ticketRepository;
    private RouteService routeService;

    public TicketService() {
        ticketRepository = new TicketRepository();
        routeService = new RouteService();
    }



    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}
