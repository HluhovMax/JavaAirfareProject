package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.Status;
import airfare.mvc.model.staff.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private JavaIOUtil original;
    private String filePath =
            "src\\main\\resources\\files\\tickets.csv";
    private UserRepository userRepository = new UserRepository();
    private RouteRepository routeRepository = new RouteRepository();

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
        User user = ticket.getUser();
        Route route = ticket.getRoute();
        String ticketToSave = ticket.getId() + "," +
                user.getId() + ","
                + route.getId() + ","
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

    public Ticket getById(Long id) {
        Ticket ticket;
        UserRepository userRepository = new UserRepository();
        RouteRepository routeRepository = new RouteRepository();
        User user;
        Route route;
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
        for (String stringOfTickets : items) {
            stringOfTickets = stringOfTickets.trim();
            String[] arr = stringOfTickets.split(",");
            Long ticketID = Long.valueOf(arr[0]);
            if (id.equals(ticketID)) {
                user = userRepository.get(Long.valueOf(arr[1]));
                route = routeRepository.getById(Long.valueOf(arr[2]));
                double price = Double.valueOf(arr[3]);
                CabineType cabineType = CabineType.valueOf(arr[4]);
                Status status = Status.FREE;
                ticket =
                        new Ticket(
                                ticketID,
                                user,
                                route,
                                new BigDecimal(price),
                                cabineType, status);
                return ticket;
            }
        }
        return null;
    }

    public void delete(Long id) {
        JavaIOUtil copy = (JavaIOUtil) original.copy();
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     copy.reader()) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if (fileTostring.length() != 0) {
                    items.add(fileTostring);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        for (String s : items) {
            String[] arr = s.split(",");
            if (id.equals(Long.valueOf(arr[0]))) {
                s = "removed";
                list.add(s);
            }
            list.add(s);
            list.remove("removed");
        }
        items = list;
        try (FileWriter writer =
                     new FileWriter(filePath)) {
            for (String s : items) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(Ticket ticket) {
        JavaIOUtil copy = (JavaIOUtil) original.copy();
        String fileToString;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     copy.reader()) {
            while ((fileToString = reader.readLine()) != null) {
                fileToString = fileToString.trim();
                if (fileToString.length() != 0) {
                    items.add(fileToString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = ticket.getUser();
        Route route = ticket.getRoute();
        String rewriteTicketToFile = ticket.getId() + "," +
                user.getId() + ","
                + route.getId() + ","
                + ticket.getPrice() + ","
                + ticket.getCabineType() + ","
                + ticket.getStatus();
        List<String> list = new ArrayList<>();
        for (String s : items) {
            String[] arr = s.split(",");
            if (Long.valueOf(arr[0]).equals(ticket.getId())) {
                s = "removed";
                list.add(s);
                list.add(rewriteTicketToFile);
            }
            list.add(s);
            list.remove("removed");
        }
        items = list;
        try (FileWriter writer =
                     new FileWriter(filePath)) {
            for (String s : items) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Ticket> getAll() {
        Ticket ticket;
        List<Ticket> ticketList = new ArrayList<>();
        JavaIOUtil copy = (JavaIOUtil) original.copy();
        String fileTostring;
        List<String> items = new ArrayList<>();
        try (BufferedReader reader =
                     copy.reader()) {
            while ((fileTostring = reader.readLine()) != null) {
                fileTostring = fileTostring.trim();
                if (fileTostring.length() != 0) {
                    items.add(fileTostring);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : items) {
            String[] arr = s.split(",");
            User user = userRepository.get(Long.valueOf(arr[1]));
            Route route = routeRepository.getById(Long.valueOf(arr[2]));
            ticket =
                    new Ticket(Long.valueOf(arr[0]),
                            user, route,
                            new BigDecimal(Double.valueOf(arr[3])),
                            CabineType.valueOf(arr[4]),
                            Status.valueOf(arr[5]));
            ticketList.add(ticket);
        }
        return ticketList;
    }
}
