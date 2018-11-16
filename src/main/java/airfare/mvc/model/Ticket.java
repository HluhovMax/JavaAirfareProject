package airfare.mvc.model;

import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Ticket {
    private User user;
    private Route route;
    private BigDecimal price;
    private CabineType cabineType;
    private boolean status;

    public Ticket() {
    }

    public Ticket(User user, Route route, BigDecimal price, CabineType cabineType, boolean status) {
        this.user = user;
        this.route = route;
        this.price = price;
        this.cabineType = cabineType;
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCabineType(CabineType cabineType) {
        this.cabineType = cabineType;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public Route getRoute() {
        return route;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CabineType getCabineType() {
        return cabineType;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return ""+user + route + price + cabineType + status + "/";
    }

}
