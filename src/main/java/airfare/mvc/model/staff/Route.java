package airfare.mvc.model.staff;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Route {
    private Long id;
    private String from;
    private String to;
    private SimpleDateFormat spf;
    private Date depatureDate;
    private Date arrivalDate;

    public Route() {
    }

    public Route(Long id, String from, String to, String dep, String arr) {
        this.id = id;
        this.from = from;
        this.to = to;
        spf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        depatureDate = new Date();
        arrivalDate = new Date();
        try {
            depatureDate = spf.parse(dep);
            arrivalDate = spf.parse(arr);
        } catch (ParseException e) {
            System.out.println("");
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return id + "," + from + "," + to + "," + depatureDate + "," + arrivalDate;
    }
}
