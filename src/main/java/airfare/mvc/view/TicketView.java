package airfare.mvc.view;

import airfare.mvc.controller.TicketController;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;

public class TicketView {
    private TicketController ticketController;

    public TicketView() {
        ticketController = new TicketController();
    }

    public void save(String from,
                     String to,
                     String depDate,
                     String arrivalDate,
                     String name, String lastName,
                     CabineType cabineType) {
        ticketController.save(from, to, depDate, arrivalDate, name,
                lastName, cabineType);
    }

    public Ticket get(Long id) {
        Ticket ticket = ticketController.get(id);
        return ticket;
    }
}
