package view;

import controller.BookingController;

import java.util.Scanner;

public class SignupView {
    Scanner scanner=new Scanner(System.in);
    public void createAccount(int userId) {
        System.out.println("Enter your name ");
        String name=scanner.next();
        System.out.println("Enter your password");
        String password=scanner.next();
        BookingController bookingController=new BookingController();
        bookingController.createAccount(name,password,userId);
    }
}
