package controller;

import model.Database;
import model.Flight;

import java.util.List;

public class AdminController {
    public void addFlight(String flightName, int flightId, String departureTime, String arrivalTime, List<String> routes, int seats, int price){
        Flight flight=new Flight(flightName,flightId,departureTime,arrivalTime,routes,seats,price);
        Database database=new Database();
        database.addflight(flight,flightId);
        System.out.println(database.flightDatabase);
    }
}
