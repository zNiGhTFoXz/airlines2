package project.entity;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;

import java.io.Serializable;
import java.util.Date;

public class Flight extends Entity implements Serializable{
    private long number;
    private String airbus;
    private String route;
    private Date timeFrom;
    private Date timePath;

    public long getNumber() {
        return number;
    }

    public String getAirbus() {
        return airbus;
    }

    public String getRoute() {
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

    public void setRoute(String route) {
        this.route = route;
    }

    public void setTimeFrom(Date timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimePath(Date timePath) {
        this.timePath = timePath;
    }
}
