package airfare.mvc.model;

import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public abstract class TicketBuilder {
    Ticket ticket;

    public TicketBuilder(Ticket ticket) {
        this.ticket = ticket;
    }

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
