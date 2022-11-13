package controller;

import model.Database;
import model.Flight;

import java.util.List;

public class AdminController {
    private static AdminController adminController=null;
    public static AdminController getInstance(){
        if(adminController==null){
            adminController=new AdminController();
        }
        return  adminController;
    }
    public void addFlight(String flightName, int flightId, String departureTime, String arrivalTime, List<String> routes, int seats, int price){
        Flight flight=new Flight(flightName,flightId,departureTime,arrivalTime,routes,seats,price);
        Database database=new Database();
        database.addFlight(flight,flightId);
        System.out.println(Database.flightDatabase);
    }

    

    public void removeFlight(int flightId) {
        Database.flightDatabase.remove(flightId);
    }

    public void viewPassenger(int pnrNumber) {
        for(int i=0;i<Database.bookedPassengers.get(pnrNumber).size();i++) {
            System.out.println(Database.bookedPassengers.get(pnrNumber).get(i));
        }
        System.out.println("\nFlight removed Successfully");
    }

}
