package controller;

import model.Database;
import model.Passenger;
import view.BookingView;

import javax.xml.crypto.Data;
import java.util.HashMap;

public class BookingController {
    static  int pnrNumber=1235;
    public void booking(String name,int age,String gender,int  id,int index,int numberOfTickets,int flightId) {
        if(index!=numberOfTickets) {
            Passenger passenger = new Passenger(name, id, age, gender,flightId);
            Database database=new Database();
            database.addPassengers(pnrNumber,passenger);
            int remainingSeats=Database.flightDatabase.get(flightId).getSeats()-1;
            Database.flightDatabase.get(flightId).setSeats(remainingSeats);
        }
        else{
            Passenger passenger=new Passenger(name, id, age, gender,flightId);
            Database database=new Database();
            int bookedPNR_Number=pnrNumber;
            database.addPassengers(pnrNumber++,passenger);
            BookingView bookingView=new BookingView();
            int remainingSeats=Database.flightDatabase.get(flightId).getSeats()-1;
            Database.flightDatabase.get(flightId).setSeats(remainingSeats);
            int totalPrice=Database.flightDatabase.get(flightId).getPrice()*numberOfTickets;
            System.out.println("Your Tickets Successfully Booked");
            bookingView.display(bookedPNR_Number,Database.bookedPassengers,totalPrice);
        }
    }

    public void cancelTickets(int pnr_number) {
        BookingView bookingView=new BookingView();
        Database database=new Database();
        int totalPrice=Database.flightDatabase.get(Database.bookedPassengers.get(pnr_number).get(0).getFlightId()).getPrice()*Database.bookedPassengers.get(pnr_number).size();
        System.out.println("Passenger Details");
        bookingView.displayCancel(pnr_number,database.bookedPassengers,totalPrice);
        database.bookedPassengers.remove(pnr_number);
    }

    public void viewTickets(int pnr_number) {
        BookingView bookingView=new BookingView();
        int totalPrice=Database.flightDatabase.get(Database.bookedPassengers.get(pnr_number).get(0).getFlightId()).getPrice()*Database.bookedPassengers.get(pnr_number).size();
        System.out.println("Passenger Details :");
        bookingView.display(pnr_number,Database.bookedPassengers,totalPrice);
    }
}
