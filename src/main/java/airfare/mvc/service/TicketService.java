package airfare.mvc.service;

import airfare.mvc.dao.TicketRepository;
import airfare.mvc.dao.UserRepository;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.TicketBuilder;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.Status;
import airfare.mvc.model.staff.User;

public class TicketService{
    private TicketRepository ticketRepository;
    private RouteService routeService;
    private TicketBuilder ticketBuilder;
    private UserRepository userRepository;

    public TicketService() {
        ticketRepository = new TicketRepository();
        routeService = new RouteService();
        ticketBuilder = new TicketBuilder();
        userRepository = new UserRepository();
    }

    public void createTicket(String from,
                             String to,
                             String depDate,
                             String arrivalDate,
                             String name, String lastName,
                             CabineType cabineType) {
        Route route = routeService.findRoute(from, to, depDate, arrivalDate);
        User user = ticketBuilder.buildUser(name, lastName);
        userRepository.save(user);
        Ticket ticket = ticketBuilder.buildTicket(name, lastName, route, cabineType);
        ticketRepository.save(ticket);
    }
}
