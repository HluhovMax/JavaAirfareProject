package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class Director {
    TicketBuilder builder;

    public void setBuilder(TicketBuilder builder) {
        this.builder = builder;
    }

    public Ticket buildTicket() {
        builder.createTicket();
        builder.buildUser();
        builder.buildRoute();
        builder.buildPrice();
        builder.buildCabinType();
        builder.buildStatus();
        Ticket ticket = builder.getTicket();
        return ticket;
    }
}
