package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class TicketFactory {
    Copyable ticket;

    public TicketFactory(Copyable ticket) {
        this.ticket = ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket cloneTicket() {
        return (Ticket) ticket.copy();
    }
}
