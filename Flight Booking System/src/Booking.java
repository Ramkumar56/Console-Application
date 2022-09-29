import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Booking {
    public static Passengers PassengersDetails(String name, int passportNo) {
        Passengers details = new Passengers();
        details.Name = name;
        details.PassportNumber = passportNo;
        return details;
    }

    public static void Book(Flight currentFlight, int tickets, int passengerId, Passengers PassengersDetails) {
        String passengerDetails = "";
        passengerDetails = "Name: " + PassengersDetails.Name + "\npassport number: " + PassengersDetails.PassportNumber + "\nPassenger Id : " + passengerId + " \nNumber of tickets Booked: " + tickets + " \n Total cost  " + currentFlight.Price * tickets;
        currentFlight.addPassengers(passengerDetails, tickets, passengerId);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void cancel(Flight currentFlight, int passengerId) {
        currentFlight.cancelTicket(passengerId);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    public static void print(Flight f) {
        f.printDetails();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Passengers> map = new HashMap<>();
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            flights.add(new Flight());
        }
        int passengerId = 1;
        while (true) {
            System.out.println("\t1.Book\n\t2.Cancel\n\t3.Print");
            System.out.println("Enter the choice");
            int ch = in.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter your Name ");
                    String name = in.next();
                    System.out.println("Enter your Passport Number");
                    int passportNo = in.nextInt();

                    System.out.println("Choice the Flight");
                    for (int i = 1; i <= flights.size(); i++) {
                        System.out.println(i + " Flight");
                    }

                    int flightNo = in.nextInt();
                    if (flightNo > flights.size()) {
                        System.out.println("Invalid Flight Number");
                    }
                    Flight currentFlight = new Flight();
                    for (Flight f : flights) {
                        if (flightNo == f.FlightId) {
                            currentFlight = f;
                            break;
                        }
                    }
                    System.out.println("Enter the Number of Tickets ");
                    int ticketsNo = in.nextInt();
                    if (ticketsNo > currentFlight.Tickets) {
                        System.out.println("Not Enough Tickets");
                    }
                    Book(currentFlight, ticketsNo, passengerId, PassengersDetails(name, passportNo));
                    passengerId++;
                    break;
                }
                case 2: {
                    System.out.println("Enter the FlightId ");
                    int flightNo = in.nextInt();
                    if (flightNo > flights.size()) {
                        System.out.println("Invalid Flight Nummber");
                    }
                    Flight currentFlight = new Flight();
                    for (Flight f : flights) {
                        if (flightNo == f.FlightId) ;
                        {
                            currentFlight = f;
                            break;
                        }
                    }
                    System.out.println("Enter the Passenger Id ");
                    int id = in.nextInt();
                    cancel(currentFlight, id);
                    break;
                }
                case 3: {
                    for (Flight f : flights) {
                        if (f.passengerDetails.size() == 0) {
                            System.out.println("\nNo passenger Details for  - Flight " + f.FlightId);
                        } else {
                            print(f);
                        }
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
