package airfare.mvc.model.staff;

import java.util.Calendar;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Route {
    private String from;
    private String to;
    private Calendar depatureDate;
    private Calendar arrivalDate;

    public Route() {
    }

    public Route(String from, String to) {
        this.from = from;
        this.to = to;
        depatureDate = Calendar.getInstance();
        arrivalDate = Calendar.getInstance();
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Calendar getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Calendar depatureDate) {
        this.depatureDate = depatureDate;
    }

    public Calendar getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Calendar arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", depatureDate=" + depatureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
