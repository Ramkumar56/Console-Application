package view;

import Model.AccountType;
import Model.Customer;
import controller.NewAccountController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import static controller.validation.*;

public class NewCustomerView {
   private Scanner scanner = new Scanner(System.in);
    public void createAccount() throws ParseException {
        Customer customer = new Customer();
        System.out.println("Enter the name ");
        String name = scanner.next();
        customer.setName(name);
        boolean check = true;
        while (check) {
            System.out.println("\nEnter Your Birth ");
            System.out.println("Enter Year : ");
            int year = scanner.nextInt();
            System.out.println("Enter Month : ");
            int month = scanner.nextInt();
            System.out.println("Enter Date : ");
            int date = scanner.nextInt();
            String dateOfBirth = "" + year + "-" + month + "-" + date;

            if (year > 1950 && year < Calendar.getInstance().get(Calendar.YEAR) - 18) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                dateFormat.parse(dateOfBirth);
                customer.setDateOfBirth(dateOfBirth);
                check = false;
            } else {
                System.out.println("\ninvalid date ");
            }
        }
        check = true;
        while (check) {
            System.out.println("Enter Gender(M-Male, F-Female, T-Trangender : ");
            String gender = "" + scanner.next().toUpperCase().charAt(0);
            if (gender.equals("M") || gender.equals("F") || gender.equals("T")) {
                customer.setGender(gender);
                check = false;
            } else {
                System.out.println("\nEnter Valid Details...");
            }
        }
        check = true;
        while (check) {
            System.out.println("Enter Email : ");
            String email = scanner.next();
            boolean isValid = isValidEmail(email);
            if (isValid) {
                customer.setEmail(email);
                check = false;
            } else {
                System.out.println("Enter Valid Email id...");
            }
        }

        check = true;
        while (check) {
            System.out.println("Enter Password : ");
            String passWord = scanner.next();
            boolean isValid = isValidPassword(passWord);
            if (isValid) {
                customer.setPassword(passWord);
                check = false;
            } else {
                System.out.println("Create PassWord(8 to 12) digits using numbers, "
                        + "characters(upper,lower), one symbol must(!@#$%&*()-+=^.),...");
            }
        }

        check = true;
        while (check) {
            System.out.println("Enter phone Number : ");
            String number = scanner.next();
            boolean isValid = isValidPhoneNumber(number);
            if (isValid) {
                customer.setPhoneNumber(number);
                check = false;
            } else {
                System.out.println("Enter Valid Phone Number...");
            }
        }


        check = true;
        AccountType accountType = null;
        while (check) {
            System.out.println("Enter choices \n1.Savings \n2.Current \n");
            int userChoice = scanner.nextInt();
            long balance = 0;
            switch (userChoice) {
                case 1: {
                    System.out.println("Enter the minimum Account Balance ");
                    balance = scanner.nextLong();
                    accountType = AccountType.SAVING;
                    break;
                }
                case 2: {
                    System.out.println("Enter the minimum Account Balance ");
                    balance = scanner.nextLong();
                    accountType = AccountType.CURRENT;
                    break;
                }
                default:{
                    System.out.println("Enter valid inputs...");
                }
            }
            customer.setBalance(balance);
            check = false;
        }
        scanner.nextLine();
        System.out.println("Enter City : ");
        String city = scanner.nextLine().toLowerCase();
        customer.setCity(city);
        customer.setAccountType(accountType);

        NewAccountController newAccountController = new NewAccountController();
        newAccountController.createAccount(customer);
    }
}
