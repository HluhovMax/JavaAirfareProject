package airfare.mvc;


import airfare.mvc.dao.TicketRepository;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.Status;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;

/**
 * Created by Max Hluhov on 14.11.2018.
 */
public class M {
    public static void main(String[] args) {
        TicketRepository ticketRepository = new TicketRepository();

        ticketRepository.update(new Ticket(1488L, new User(3L, "Ivan", "Ivanov"),
                new Route(44L, "Kyiv", "Riga", "25-12-2018 10:00:00",
                        "25-12-2018 11:00:00"), new BigDecimal(350),
                CabineType.B_CLASS, Status.BOUGHT));


    }
}
