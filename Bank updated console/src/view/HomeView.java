package view;

import java.text.ParseException;
import java.util.Scanner;

public class HomeView {
    public static void main(String[] args) throws ParseException {
       Scanner scanner = new Scanner(System.in);
        boolean clientLogin = true;
        while (clientLogin) {
            System.out.println("\t1.Create Account\n\t2.Manage Account\n\t3.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    NewCustomerView newCustomerView = new NewCustomerView();
                    newCustomerView.createAccount();
                    break;
                }
                case 2: {
                    LoginView loginView = new LoginView();
                    loginView.manage();
                }
                case 3: {
                    clientLogin = false;
                    System.out.println("Thankyou");
                    break;
                }
                default: {
                    System.out.println("Enter the valid inputs...");
                }
            }
        }
    }

}
