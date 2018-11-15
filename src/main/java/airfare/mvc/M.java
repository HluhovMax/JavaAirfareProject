package airfare.mvc;

import airfare.mvc.model.*;
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

        Director director = new Director();

        director.setBuilder(new TicketBuilderImpl(prototype));

        ticket = director.buildTicket();

        System.out.println(ticket.toString());
    }
}
