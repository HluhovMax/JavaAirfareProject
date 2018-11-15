package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class TicketFactory {
    Ticket ticket;

    public TicketFactory(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket cloneTicket() {
        return (Ticket) ticket.copy();
    }
}
