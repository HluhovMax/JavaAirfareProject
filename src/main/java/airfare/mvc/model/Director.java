package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class Director {
    AbstractTicketBuilder builder;

    public void setBuilder(AbstractTicketBuilder builder) {
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
