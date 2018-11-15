package airfare.mvc.model.staff;

import java.util.Date;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Route {
    private String from;
    private String to;
    private Date date;

    public Route(String from, String to) {
        this.from = from;
        this.to = to;
        date = new Date();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return from + " - " + to + " - " + date;
    }
}
