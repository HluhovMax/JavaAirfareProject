package airfare.mvc.model;

import airfare.mvc.model.staff.CabineType;
import airfare.mvc.model.staff.Route;
import airfare.mvc.model.staff.Status;
import airfare.mvc.model.staff.User;

import java.math.BigDecimal;

/**
 * Created by Max Hluhov on 12.11.2018.
 */
public class Ticket {
    private Long id;
    private User user;
    private Route route;
    private BigDecimal price;
    private CabineType cabineType;
    private Status status;

    public Ticket() {
    }

    public Ticket(Long id, User user, Route route, BigDecimal price, CabineType cabineType, Status status) {
        this.id = id;
        this.user = user;
        this.route = route;
        this.price = price;
        this.cabineType = cabineType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", user=" + user +
                ", route=" + route +
                ", price=" + price +
                ", cabineType=" + cabineType +
                ", status=" + status +
                '}';
    }
}
