package model;

import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String flightName;
    private int flightid;
    private String departureTime;
    private String  arrivalTime;
    private List<String>route;
    private int seats;
    private int price;
    static private int pnrnumber=1111;

    public int getPnrnumber() {
        return pnrnumber;
    }

    public void setPnrnumber(int pnrnumber) {
        this.pnrnumber = pnrnumber;
    }
    public Flight(){

    }
    public Flight(String flightName, int flightid, String departureTime, String arrivalTime, List<String> routes, int seats, int price) {
        this.flightName = flightName;
        this.flightid = flightid;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.route=routes;
        this.seats = seats;
        this.price = price;
        pnrnumber=pnrnumber++;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getFlightid() {
        return flightid;
    }

    public void setFlightid(int flightid) {
        this.flightid = flightid;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<String> getRoute() {
        return route;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
