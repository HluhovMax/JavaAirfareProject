package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.model.staff.Route;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RouteRepository {
    private JavaIOUtil original;
    private String filePath =
            "src\\main\\resources\\files\\routes.csv";

    public RouteRepository() {
        original = new JavaIOUtil(filePath);
    }

    public void save(Route route) {
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
        String routeToSave = route.getId() + "," +
                route.getFrom() + "," + route.getTo() +
                "," + route.getDepatureDate() +
                "," + route.getArrivalDate();
        items.add(routeToSave);
        try (FileWriter writer = new FileWriter(new File(filePath), true)) {
            writer.write(routeToSave + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Route getById(Long id) {
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
        for (String stringOfRoutes : items) {
            stringOfRoutes = stringOfRoutes.trim();
            String[] arr = stringOfRoutes.split(",");
            Long routeID = Long.valueOf(arr[0]);
            if (id.equals(routeID)) {
                String from = arr[1];
                String to = arr[2];
                String dep = arr[3];
                String arri = arr[4];
                route = new Route(routeID, from, to, dep, arri);
                return route;
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

    public void update(Route route) {
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
        String rewriteRouteToFile = route.getId() + "," +
                route.getFrom() + "," + route.getTo() +
                "," + route.getDepatureDate() +
                "," + route.getArrivalDate();
        List<String> list = new ArrayList<>();
        for (String s : items) {
            String[] arr = s.split(",");
            if (Long.valueOf(arr[0]).equals(route.getId())) {
                s = "removed";
                list.add(s);
                list.add(rewriteRouteToFile);
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

    public List<Route> getAll() {
        Route route;
        List<Route> routeList = new ArrayList<>();
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
            route =
                    new Route(Long.valueOf(arr[0]),
                            arr[1], arr[2], arr[3], arr[4]);
            routeList.add(route);
        }
        return routeList;
    }

    public Route findRoute(
            String from,
            String to,
            String depDate,
            String arrivalDate) {
        Route route;
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
            if ((from.equalsIgnoreCase(arr[1]))
                    && (to.equalsIgnoreCase(arr[2]))
                    && (depDate.equalsIgnoreCase(arr[3]))
                    && (arrivalDate.equalsIgnoreCase(arr[4]))) {
                route = new Route(Long.valueOf(arr[0]), arr[1], arr[2], arr[3], arr[4]);
                return route;
            }
        }
        return null;
    }
}
