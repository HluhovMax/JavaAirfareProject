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
    private String filePath = "src\\main\\resources\\files\\routes.csv";

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
        String routeToSave =
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
}
