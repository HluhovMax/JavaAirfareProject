package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.model.Ticket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private JavaIOUtil original;
    private String filePath = "src\\main\\resources\\files\\tickets.csv";

    public TicketRepository() {
        original = new JavaIOUtil(filePath);
    }

    public void save(Ticket ticket) {
        JavaIOUtil copy = (JavaIOUtil) original.copy();
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     copy.reader()) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if ((fileTostring.length()) != 0) {
                    items.add(fileTostring);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        String ticketToSave = ticket.getUser() + ","
                + ticket.getRoute() + ","
                + ticket.getPrice() + ","
                + ticket.getCabineType() + ","
                + ticket.getStatus();
        items.add(ticketToSave);
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            writer.write(ticketToSave + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
