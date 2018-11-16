package airfare.mvc.model.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Route {
    private String from;
    private String to;
    private SimpleDateFormat spf;
    private Date depatureDate;
    private Date arrivalDate;

    public Route(String from, String to, String dep, String arr) throws ParseException {
        this.from = from;
        this.to = to;
        spf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        depatureDate = new Date();
        arrivalDate = new Date();
        depatureDate = spf.parse(dep);
        arrivalDate = spf.parse(arr);
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

    public SimpleDateFormat getSpf() {
        return spf;
    }

    public void setSpf(SimpleDateFormat spf) {
        this.spf = spf;
    }

    public Date getDepatureDate() {
        return depatureDate;
    }

    public void setDepatureDate(Date depatureDate) {
        this.depatureDate = depatureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return from + "," + to + "," + depatureDate + "," + arrivalDate;
    }
}
