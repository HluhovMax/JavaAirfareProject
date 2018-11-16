package airfare.mvc.dao;

import airfare.mvc.dao.prototype.JavaIOUtil;
import airfare.mvc.dao.prototype.JavaIOUtilFactory;
import airfare.mvc.model.staff.Route;

import java.io.File;
import java.util.List;

/**
 * Created by Max Hluhov on 16.11.2018.
 */
public class RouteRepository implements Repository<Route>{
    private JavaIOUtilFactory<Route> factory;
    private File file =
            new File("src\\main\\resources\\files\\routes.txt");

    @Override
    public void save(Route route) {
        factory = new JavaIOUtilFactory<>(file, route);
        JavaIOUtil<Route> copy = factory.cloneJIOU();
        List<String> list = copy.reader();
        String routeToSave =
                route.getFrom() + "," + route.getTo() +
                        "," + route.getDepatureDate() +
                        "," + route.getArrivalDate() + "/";
        list.add(routeToSave);
        copy.writer(routeToSave);
    }
}
