package view;

//import controller.FlightBookingControl;

import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int userId=1111;
        boolean value=true;
        while(value){
            System.out.println("\nEnter the choice \n\n1.Signup \n2.login \n3.back");
            int choice=scanner.nextInt();
            switch (choice){
                case 1:{
                       SignupView signupView=new SignupView();
                       signupView.createAccount(userId);
                       userId++;
                    break;
                    }
                case 2:{
                     LoginView loginView=new LoginView();
                     loginView.userLogin();
                    break;
                }
                case 3:{
                    value=false;
                    System.out.println("Thankyou");
                    break;
                }
            }
        }
    }
}
