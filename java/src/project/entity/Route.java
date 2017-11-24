package project.entity;

/*
** Created by NiGhTFoX on 24.11.2017.
*/

import core.entity.Entity;

import java.io.Serializable;

public class Route extends Entity implements Serializable{
    private String flightFrom;
    private String flightTo;

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }
}
