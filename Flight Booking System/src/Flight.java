import java.util.ArrayList;
import java.util.List;

public class Flight {
    static int id = 0;
    int FlightId;
    int Tickets;
    int Price;
    List<Integer> bookedTicketsPerPassengers;
    List<Integer> passengerCost;

    List<Integer> passengerId;
    List<String> passengerDetails;

    Flight() {
        Tickets = 50;
        Price = 5000;
        id = id + 1;
        FlightId = id;
        bookedTicketsPerPassengers = new ArrayList<>();
        passengerId = new ArrayList<>();
        passengerCost = new ArrayList<>();
        passengerDetails = new ArrayList<>();
    }

    public void addPassengers(String passengerDetail, int tickets, int passengerid) {
        passengerDetails.add(passengerDetail);
        passengerId.add(passengerid);
        passengerCost.add(Price * tickets);
        Price = Price + 200 * tickets;
        Tickets = Tickets - tickets;
        bookedTicketsPerPassengers.add(tickets);
        System.out.println("Booked Successfully ");
    }

    public void cancelTicket(int id) {
        int index = passengerId.indexOf(id);
        if (id < 0) {
            System.out.println("Passenger Id not Found!...");
        }
        int ticketsToCancel = bookedTicketsPerPassengers.get(index);
        Tickets = +Tickets + ticketsToCancel;
        Price = Price - 200 * ticketsToCancel;
        System.out.println("Refund Amount " + passengerCost.get(index));

        bookedTicketsPerPassengers.remove(index);
        passengerId.remove(Integer.valueOf(id));
        passengerDetails.remove(index);
        passengerCost.remove(index);
        System.out.println(" Tickets Cancelled Successfully");
    }

    public void flightSummary() {
        System.out.println("\nFlight ID " + FlightId + "\nRemaining Tickets " + Tickets +
                "\nCurrent Ticket Price " + Price);
    }

    public void printDetails() {
        System.out.println("\nFlight ID " + FlightId);
        for (String detail : passengerDetails)
            System.out.println(detail + "\n");
    }


}
