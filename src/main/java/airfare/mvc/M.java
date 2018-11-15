package airfare.mvc;

import airfare.mvc.model.Director;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.TicketBuilderImpl;
import airfare.mvc.model.TicketFactory;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;

/**
 * Created by Max Hluhov on 14.11.2018.
 */
public class M {
    public static void main(String[] args) {
        Ticket ticket =
                new Ticket(new User("Ivan", "Ivanov"),
                        new Route("Kyiv", "Warsaw"), new BigDecimal(200.0),
                        CabineType.B_CLASS, true);

        TicketFactory ticketFactory = new TicketFactory(ticket);

        Ticket prototype = ticketFactory.cloneTicket();

        TicketBuilderImpl ticketBuilder = new TicketBuilderImpl();
        ticketBuilder.setCopy(prototype);
        Director director = new Director();

        director.setBuilder(ticketBuilder);

        ticket = director.buildTicket();

        System.out.println(ticket.toString());
    }
}
