package airfare.mvc.view;

import airfare.mvc.dao.RouteRepository;
import airfare.mvc.model.Ticket;
import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.view.TicketView;

import java.util.List;
import java.util.Scanner;

public class ConsoleHelper {
    private TicketView ticketView;
    private RouteRepository routeRepository;

    public ConsoleHelper() {
        ticketView = new TicketView();
        routeRepository = new RouteRepository();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 'b' to buy a ticket, 'r' to return");
        String responce = scanner.nextLine();
        switch (responce) {
            case "b":
                System.out.println("enter your name, last name");
                String name = scanner.nextLine();
                String lastName = scanner.nextLine();
                System.out.println("enter from, to, depature(dd-M-yyyy hh:mm:ss)," +
                        " arrival(dd-M-yyyy hh:mm:ss)," +
                        " cabin type(B_CLASS, E_CLASS)");
                String from = scanner.nextLine();
                String to = scanner.nextLine();
                String dep = scanner.nextLine();
                String arrive = scanner.nextLine();
                String cabine = scanner.nextLine();
                CabineType cabineType = CabineType.valueOf(cabine);
                ticketView.save(from, to, dep, arrive, name, lastName, cabineType);
                break;
            case "r":
                System.out.println("enter your ticket id");
                String id = scanner.nextLine();
                Ticket ticket = ticketView.get(Long.valueOf(id));
                System.out.println(ticket);
                break;
        }
    }
}
