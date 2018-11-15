package airfare.mvc.model;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class TicketBuilderImpl extends TicketBuilder {
    Ticket copy;

    public TicketBuilderImpl(Ticket copy) {
        this.copy = copy;
    }

    @Override
    void buildUser() {
        ticket.setUser(copy.getUser());
    }

    @Override
    void buildRoute() {
        ticket.setRoute(copy.getRoute());
    }

    @Override
    void buildPrice() {
        ticket.setPrice(copy.getPrice());
    }

    @Override
    void buildCabinType() {
        ticket.setCabineType(copy.getCabineType());
    }

    @Override
    void buildStatus() {
        ticket.setStatus(copy.isStatus());
    }
}
