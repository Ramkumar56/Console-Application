//package controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FlightBookingControl {
//    static int id = 0;
//    int ticket;
//    int price;
//    List<Integer> bookedTicketsPerPassengers;
//    List<Integer> passengerCost;
//
//    List<Integer> passengerId;
//    List<String> passengerDetails;
//
//    public FlightBookingControl() {
//        ticket = 50;
//        price = 5000;
//        id = id + 1;
//        bookedTicketsPerPassengers = new ArrayList<>();
//        passengerId = new ArrayList<>();
//        passengerCost = new ArrayList<>();
//        passengerDetails = new ArrayList<>();
//    }
//    public void booking(String passengerDetail, int passengerid, int tickets) {
//
//        passengerDetails.add(passengerDetail);
//        passengerId.add(passengerid);
//        passengerCost.add(price * tickets);
//        price = price + 200 * tickets;
//        ticket = ticket - tickets;
//        bookedTicketsPerPassengers.add(tickets);
//        System.out.println("Booked Successfully ");
//    }
//    public void cancelTicket(int id) {
//        int index = passengerId.indexOf(id);
//        if (id < 0) {
//            System.out.println("Passenger Id not Found!...");
//        }
//        int ticketsToCancel = bookedTicketsPerPassengers.get(id);
//        ticket = +ticket + ticketsToCancel;
//        price = price - 200 * ticketsToCancel;
//        System.out.println("Refund Amount " + passengerCost.get(id));
//
//        bookedTicketsPerPassengers.remove(id);
//        passengerId.remove(Integer.valueOf(id));
//        passengerDetails.remove(id);
//        passengerCost.remove(id);
//        System.out.println(" Tickets Cancelled Successfully");
//    }
//    public void flightSummary() {
//        System.out.println("\nFlight ID " + "\nRemaining Tickets " + ticket +
//                "\nCurrent Ticket Price " + price);
//    }
//    public void printDetails() {
//        for (String detail : passengerDetails)
//            System.out.println(detail + "\n");
//    }
//}
