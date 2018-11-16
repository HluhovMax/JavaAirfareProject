package airfare.mvc.view;

import airfare.mvc.model.staff.Route;

import java.util.Scanner;

/**
 * Created by Max Hluhov on 15.11.2018.
 */
public class RouteView {
    Route route;

    public RouteView() {
        route = new Route();
    }

    public Route getRoute() {
        String from;
        String to;
        String depatureDate;
        String arrivalDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter from:");
        from = scanner.nextLine();
        System.out.println("enter to:");
        to = scanner.nextLine();
        System.out.println("enter depatureDate(y, d, m): ");
        depatureDate = scanner.nextLine();
        System.out.println("enter arrivalDate(y, d, m): ");
        arrivalDate = scanner.nextLine();
        return null;
    }
}
