package airfare.mvc;

import airfare.mvc.dao.TicketRepository;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * Created by Max Hluhov on 14.11.2018.
 */
public class M {
    public static void main(String[] args) throws ParseException, InterruptedException {
        TicketRepository ticketRepository = new TicketRepository();

        ticketRepository.save(new Ticket(new User("Ivan", "Ivanov"),
                new Route("Kyiv", "Riga", "25-12-2018 10:00:00",
                        "25-12-2018 11:00:00"), new BigDecimal(200.0),
                CabineType.B_CLASS, true));
    }
}
