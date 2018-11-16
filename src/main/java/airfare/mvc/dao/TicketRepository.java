package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.dao.prototype.JavaIOUtilFactory;
import airfare.mvc.model.Ticket;

import java.io.File;
import java.util.List;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public class TicketRepository implements Repository<Ticket> {
    private JavaIOUtilFactory<Ticket> factory;
    private File file =
            new File("src\\main\\resources\\files\\tickets.txt");
    
    @Override
    public void save(Ticket ticket) {
        factory = new JavaIOUtilFactory<>(file, ticket);
        JavaIOUtil<Ticket> copy = factory.cloneJIOU();
        List<String> list = copy.reader();
        String ticketToSave = ticket.getUser() + "/"
                + ticket.getRoute() + "/"
                + ticket.getPrice() + "/"
                + ticket.getCabineType() + "/"
                + ticket.getStatus() + "/";
        list.add(ticketToSave);
        copy.writer(ticketToSave);
    }
}
