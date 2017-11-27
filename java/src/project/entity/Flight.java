package project.entity;

import core.entity.Entity;

import java.util.Date;

public class Flight extends Entity {
    private long number;
    private String airbus;
    private Route route;
    private Date timeFrom;
    private Date timePath;

    public long getNumber() {
        return number;
    }

    public String getAirbus() {
        return airbus;
    }

    public Route getRoute() {
        return route;
    }

    public Date getTimeFrom() {
        return timeFrom;
    }

    public Date getTimePath() {
        return timePath;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setAirbus(String airbus) {
        this.airbus = airbus;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimePath(Date timePath) {
        this.timePath = timePath;
    }
}
