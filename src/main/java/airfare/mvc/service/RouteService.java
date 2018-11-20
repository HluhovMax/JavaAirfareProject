package airfare.mvc.service;

import airfare.mvc.dao.RouteRepository;
import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.model.staff.Route;

import java.util.Scanner;

public class RouteService {
    private RouteRepository routeRepository;
    private Scanner scanner;

    public RouteService() {
        routeRepository = new RouteRepository();
        scanner = new Scanner(System.in);
    }

    public Route findRoute(String from,
                           String to,
                           String depDate,
                           String arrivalDate) {
        Route route =
                routeRepository.findRoute(from, to, depDate, arrivalDate);
        return route;
    }
}
