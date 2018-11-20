package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class TicketBuilderImpl extends AbstractTicketBuilder {


    public TicketBuilderImpl(Ticket ticket) {
        super(ticket);
    }

    @Override
    void buildUser() {
        this.ticket.setUser(ticket.getUser());
    }

    @Override
    void buildRoute() {
        this.ticket.setRoute(ticket.getRoute());
    }

    @Override
    void buildPrice() {
        this.ticket.setPrice(ticket.getPrice());
    }

    @Override
    void buildCabinType() {
        this.ticket.setCabineType(ticket.getCabineType());
    }

    @Override
    void buildStatus() {
        this.ticket.setStatus(ticket.getStatus());
    }
}
