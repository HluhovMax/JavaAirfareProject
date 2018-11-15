package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public abstract class TicketBuilder {
    Ticket ticket;

    void createTicket() {
        ticket = new Ticket();
    }

    abstract void buildUser();

    abstract void buildRoute();

    abstract void buildPrice();

    abstract void buildCabinType();

    abstract void buildStatus();

    Ticket getTicket() {
        return ticket;
    }
}
