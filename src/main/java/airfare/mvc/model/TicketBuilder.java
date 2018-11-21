package airfare.mvc.model;


import airfare.mvc.dao.TicketRepository;
import airfare.mvc.dao.UserRepository;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.Status;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;
import java.util.List;

public class TicketBuilder {
    private Ticket ticket = new Ticket();

    public User buildUser(String name, String lastName) {
        UserRepository userRepository = new UserRepository();
        List<User> userList = userRepository.getAll();
        User lastU = userList.get(userList.size() - 1);
        User user = new User((lastU.getId() + 1), name, lastName);
        return user;
    }

    public Ticket buildTicket(String name, String lastName,
                              Route route, CabineType cabineType) {
        ticket.setStatus(Status.BOUGHT);
        ticket.setPrice(new BigDecimal(200));
        ticket.setUser(buildUser(name, lastName));
        TicketRepository ticketRepository = new TicketRepository();
        List<Ticket> ticketList = ticketRepository.getAll();
        Ticket lastT = ticketList.get(ticketList.size() - 1);
        ticket.setId(lastT.getId() + 1);
        ticket.setCabineType(cabineType);
        ticket.setRoute(route);
        return ticket;
    }
}
