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
            Passenger passenger = new Passenger(name, id, age, gender);
            Database database = new Database();
            database.addPassengerDetails(passenger);
            int remainingSeats=database.flightDatabase.get(flightId).getSeats()-1;
            database.flightDatabase.get(flightId).setSeats(remainingSeats);
        }
        else{
            Passenger passenger=new Passenger(name, id, age, gender);
            Database database=new Database();
            database.addPassengerDetails(passenger);
            int bookedPNR_Number=pnrNumber;
            database.addPassengers(pnrNumber++);
            BookingView bookingView=new BookingView();
            int remainingSeats=database.flightDatabase.get(flightId).getSeats()-1;
            database.flightDatabase.get(flightId).setSeats(remainingSeats);
            bookingView.display(bookedPNR_Number,database.bookedPassengers);
        }
    }

    public void cancelTickets(int pnr_number) {
        Database database=new Database();
        BookingView bookingView=new BookingView();
        System.out.println("Passenger Details");
        bookingView.display(pnr_number,database.bookedPassengers);
        database.bookedPassengers.remove(pnr_number);
    }

    public void viewTickets(int pnr_number) {
        Database database=new Database();
        BookingView bookingView=new BookingView();
        System.out.println("Passenger Details");
        bookingView.display(pnr_number,database.bookedPassengers);
        database.bookedPassengers.remove(pnr_number);
    }
}
