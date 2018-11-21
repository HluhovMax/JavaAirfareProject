package airfare.mvc.controller;

import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController() {
        ticketService = new TicketService();
    }

    public void save(String from,
                     String to,
                     String depDate,
                     String arrivalDate,
                     String name, String lastName,
                     CabineType cabineType) {
        ticketService.createTicket(from, to, depDate,
                arrivalDate, name, lastName, cabineType);
    }

    public Ticket get(Long id) {
        Ticket ticket = ticketService.returnTicket(id);
        return ticket;
    }
}
