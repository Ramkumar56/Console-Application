package view;

import controller.AdminController;
import controller.BookingController;
import controller.UserController;
import model.Database;
import model.Flight;
import model.UserDetails;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    private Scanner scanner=new Scanner(System.in);
    private void userHome() {
        try {
            Boolean userHomeCheck = true;
            do {
                System.out.println("\n\nEnter the choice \n1.Booking \n2.Booked Tickets \n3.Cancel Tickets \n4.List of routes \n5.back");
                int value=scanner.nextInt();
                BookingView bookingView=new BookingView();
                switch (value){
                    case 1:
                        bookingView.booking();
                        break;
                    case 2:
                        bookingView.viewBookedTickets();
                        break;
                    case 3:
                        bookingView.cancelTickets();
                        break;
                    case 4:
                        bookingView.listOfRoutes();
                        break;
                    case 5:
                         userHomeCheck=false;
                         break;
                    default:
                        System.out.println("Enter the valid Inputs");
                }
            } while (userHomeCheck);
        }catch (InputMismatchException e){
            System.out.println("Enter the valid inputs");
        }
    }
    private Boolean checkUser() {
        Boolean userCheck=true;
        do {
            System.out.println("\n\nPlease Select option \n1.signup \n2.login");
            int value=scanner.nextInt();
            switch (value){
                case 1:
                    UserView userView=new UserView();
                    userView.signup();
                    break;
                case 2:
                    UserView userView1=new UserView();
                    if(userView1.login())
                        return true;

            }
        }while (userCheck);
        return false;
    }

    private Boolean login() {
        System.out.println("Enter the userId");
        int userId= scanner.nextInt();
        System.out.println("Enter the Password");
        String passwordCheck= scanner.next();
        UserController userController1=new UserController();
        if(userController1.isValidUser(userId,passwordCheck)) {
            return true;
        }
        return false;
    }

    private void signup() {
        System.out.println("Enter the Name");
        String name=scanner.next();
        System.out.println("Enter the phone number");
        long phoneNumber=scanner.nextLong();
        System.out.println("Enter the email");
        String email=scanner.next();
        System.out.println("Enter the password");
        String password=scanner.next();
        UserController userController=new UserController();
        userController.addUserDetails(name,phoneNumber,email,password);
    }

    public void displayUserDetails(UserDetails userDetails) {
        System.out.println("\n\nPlease remember your id and password");
        System.out.println("your user Id is "+userDetails.getUserId());
        System.out.println("Your name is "+userDetails.getName());
        System.out.println("your password is "+userDetails.getPassword());

    }
    public void init() {
        UserView userView=new UserView();
        if(userView.checkUser())
            userView.userHome();
    }
}
