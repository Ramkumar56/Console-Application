package view;

import controller.BookingController;

import java.util.Scanner;

public class LoginView {
    Scanner scanner=new Scanner(System.in);
    public void userLogin(){
        int passengerId=111;
        BookingController bookingController = new BookingController();
        Boolean userLogin=true;
        Boolean bookingHomeView=false;
        int userId=0;
        while (userLogin) {
            System.out.println("Enter userId");
             userId = scanner.nextInt();
            System.out.println("Enter password ");
            String password = scanner.next();
            if (bookingController.isValidUser(userId, password)) {
                 userLogin=false;
                 bookingHomeView=true;
            }
            else{
                System.out.println("Enter the valid userid and password");
                userLogin=true;
            }
        }
        while(bookingHomeView){
            System.out.println("\nEnter the choice \n1.BookTickets \n2.cancel ");
            int userChoice=scanner.nextInt();
            switch (userChoice){
                case 1:{
                    System.out.println("Enter the Name ");
                    String name=scanner.next();
                    System.out.println("Enter the Passport Number");
                    int passportNumber=scanner.nextInt();
                    System.out.println("Enter the number of tickets ");
                    int numberOfTickets=scanner.nextInt();
                    bookingController.ticketBooking(name,passportNumber,passengerId,numberOfTickets);
                    System.out.println("\nYour Tickets successfully booked");
                    passengerId++;
                    break;
                }
                case 2:{
                    System.out.println("\nEnter the Passenger Id");
                    int passengerID= scanner.nextInt();
                    if (passengerID < 0) {
                        System.out.println("\nPassenger Id not Found!...");
                    }
                    else
                    bookingController.ticketCancel(passengerID);
                    break;
                }
                case 3:{

                }
            }
        }
    }

    public void refundAmount(String refundAmount) {
        System.out.println("Your Refund Amount is"+refundAmount);
    }

    public void print(String passengerDetails) {
        System.out.println(passengerDetails);
    }
}
