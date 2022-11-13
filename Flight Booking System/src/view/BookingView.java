package view;

import controller.AdminController;
import controller.BookingController;
import model.Database;
import model.Flight;
import model.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookingView {
    private Scanner scanner=new Scanner(System.in);
    static int id=1111;
    public void booking() {
        System.out.println("-----------Flight Details-----------");
        for(Map.Entry<Integer, Flight>flightEntry: Database.flightDatabase.entrySet()){
            System.out.println("\n\nFlight Name: "+flightEntry.getValue().getFlightName());
            System.out.println("Flight Id: "+flightEntry.getValue().getFlightid());
            System.out.println("Flight Departure Time: "+flightEntry.getValue().getDepartureTime());
            System.out.println("Flight Arrival Time: "+flightEntry.getValue().getArrivalTime());
            System.out.println("Available Seats: "+flightEntry.getValue().getSeats());
            System.out.println("Flight Routes: "+flightEntry.getValue().getRoute());
            System.out.println("Flight Price: "+flightEntry.getValue().getPrice());
        }
        System.out.println("\nEnter the Flight Id");
        int flightId=scanner.nextInt();
        System.out.println("Enter the number of tickets ");
        int numberOfTickets=scanner.nextInt();
        if(numberOfTickets<=Database.flightDatabase.get(flightId).getSeats()) {
            for (int i = 1; i <= numberOfTickets; i++) {
                System.out.println("\nEnter your name of " + i + " passenger");
                String name = scanner.next();
                System.out.println("Enter your age");
                int age = scanner.nextInt();
                System.out.println("Enter your gender");
                String gender = scanner.next();
                BookingController bookingController = new BookingController();
                bookingController.booking(name, age, gender, id++, i, numberOfTickets, flightId);
            }
        }
        else{
            System.out.println(numberOfTickets+"Not Available "+"\n  only "+Database.flightDatabase.get(flightId).getSeats());
        }
    }

    public void display(int pnrNumber, HashMap<Integer, List<Passenger>> bookedPassengers,int totalPrice) {
          for(int i=0;i<bookedPassengers.get(pnrNumber).size();i++){
            System.out.println("\n\nPassenger Name:"+bookedPassengers.get(pnrNumber).get(i).getName());
            System.out.println("Passenger Id:"+bookedPassengers.get(pnrNumber).get(i).getId());
            System.out.println("Passenger Age:"+bookedPassengers.get(pnrNumber).get(i).getAge());
            System.out.println("Passenger Gender:"+bookedPassengers.get(pnrNumber).get(i).getGender());
        }
        System.out.println("Total price:"+totalPrice);
        System.out.println("\nYour PNR Number is " +pnrNumber);
    }


    public void viewBookedTickets() {
        System.out.println(" please Enter your pnr number");
        int pnr_Number=scanner.nextInt();
        BookingController bookingController=new BookingController();
        bookingController.viewTickets(pnr_Number);
    }

    public void cancelTickets() {
        System.out.println(" please Enter your pnr number");
        int pnr_Number=scanner.nextInt();
        BookingController bookingController=new BookingController();
        bookingController.cancelTickets(pnr_Number);
    }

    public void listOfRoutes() {
        Database database =new Database();
        System.out.println("The Routes are \n");
        for(Map.Entry<Integer,Flight>flightRoutes:database.flightDatabase.entrySet()){
            System.out.println(flightRoutes.getValue().getRoute());
        }
    }

    public void displayCancel(int pnrNumber, HashMap<Integer, List<Passenger>> bookedPassengers, int totalPrice) {
        for(int i=0;i<bookedPassengers.get(pnrNumber).size();i++){
            System.out.println("\n\nPassenger Name:"+bookedPassengers.get(pnrNumber).get(i).getName());
            System.out.println("Passenger Id:"+bookedPassengers.get(pnrNumber).get(i).getId());
            System.out.println("Passenger Age:"+bookedPassengers.get(pnrNumber).get(i).getAge());
            System.out.println("Passenger Gender:"+bookedPassengers.get(pnrNumber).get(i).getGender());
        }
        System.out.println("Total price:"+totalPrice);
        System.out.println("\nYour PNR Number is " +pnrNumber);
        System.out.println("Your Tickets Successfully cancelled");
    }

}
