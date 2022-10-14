package controller;

import model.Passengers;
import model.User;
import view.LoginView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    Scanner scanner= new Scanner(System.in);
    static  HashMap<Integer, User> userHashMap =new HashMap<>();
    static  HashMap<Integer, Passengers> passengersHashMap=new HashMap<>();
    static int totalTickets=50;
    static int price=5000;
    public void createAccount(String name, String password, int userId) {
        userHashMap.put(userId,new User(name,password,userId));
        System.out.println("****Signup Completed****");
        System.out.println("Your userid is "+userId);
    }
    public  boolean isValidUser(int userId, String password) {
        if(userHashMap.containsKey(userId)){
            if(userHashMap.get(userId).getPassword().equals(password)){
                return true;
            }
        }
       return false;
    }


    public void ticketBooking(String name,int passportNumber,int passengerId,int numberOfTickets) {
        Passengers passengers=new Passengers();
        if(numberOfTickets<totalTickets){
            passengers.setName(name);
            passengers.setPassportNumber(passportNumber);
            passengers.setBookedTicketsPerPassengers(numberOfTickets);
            passengers.setPassengerCost(price*numberOfTickets);
            passengers.setPassengerId(passengerId);
            price=price+200*numberOfTickets;
            totalTickets=totalTickets-numberOfTickets;
            passengersHashMap.put(passengerId,passengers);
            String passengerDetails="Passenger Name "+passengers.getName()+"\nPassenger ID "+passengers.getPassengerId()+"\nPassport Number"+passengers.getPassportNumber()+
                    "\nTotal Tickets Booked by You "+passengers.getBookedTicketsPerPassengers()+"\nTotal Amount "+passengers.getPassengerCost();
            LoginView loginView=new LoginView();
            loginView.print(passengerDetails);
        }
    }

    public void ticketCancel(int passengerID) {
        int ticketsToCancel=passengersHashMap.get(passengerID).getBookedTicketsPerPassengers();
        totalTickets=totalTickets+ticketsToCancel;
        price=price-200*ticketsToCancel;
        String refundAmount= String.valueOf(passengersHashMap.get(passengerID).getPassengerCost());
        passengersHashMap.remove(passengerID);
        LoginView loginView=new LoginView();
        loginView.refundAmount(refundAmount);
    }
}
