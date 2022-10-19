package view;

import Model.Account;
import Model.Customer;
import Model.Transaction;
import controller.UserController;

import java.util.Scanner;

public class UserControllView {
    Scanner scanner=new Scanner(System.in);
    public void viewUser(String customerId) {
        UserController userController=new UserController();
        boolean isValue = true;
        while (isValue) {
            System.out.println("\nEnter You Want to do  \n1.Customer Detail"
                    + "\n2.User Account Details \n3.User Transactions Details \n4.Back ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    Customer customer=userController.customerDetail(customerId);
                    if (customer.getCustomerid()!=0) {
                        System.out.println("\n***********************USER INFO***********************\n");
                        System.out.println("Customer ID      : " + customer.getName());
                        System.out.println("Name             : " + customer.getName());
                        System.out.println("Gender           : " + customer.getGender());
                        System.out.println("Date of Birth    : " + customer.getDateOfBirth());
                        System.out.println("Email            : " + customer.getEmail());
                        System.out.println("Phone Number     : " + customer.getPhoneNumber());
                        System.out.println("Account Type     : " + customer.getAccountType());
                        System.out.println("City             : " + customer.getCity());
                        System.out.println("Password         : " + customer.getPassword());
                        isValue = false;
                    }
                    else
                        System.out.println("CustomerId Not found...");
                    break;
                }
                case 2: {
                    Account account=userController.accountview(customerId);
                    System.out.println("\n***********************ACCOUNT INFO***********************\n");
                    System.out.println("Customer ID      : " + account.getCustomerid());
                    System.out.println("Account Number   : " + account.getAccountnumber());
                    System.out.println("Account Balance  : " + account.getAccountbalance());
                    System.out.println("Account Status   : " + account.getAccountstatus());
                    break;
                }
                case 3: {
                    Transaction transaction=userController.viewTransactions(customerId);
                    if (transaction != null) {
                        System.out.println("\n***********************TRANSACTION INFO***********************\n");
                        System.out.println("Customer Id          : " + transaction.getCustomerid());
                        System.out.println("Date of Transaction  : " + transaction.getDateOfTransaction());
                        System.out.println("Transaction Type     : " + transaction.getTransactionType());
                        System.out.println("Transaction Amount   : " + transaction.getTransactionAmount());
                        isValue = false;
                    } else {
                        System.out.println("No Transaction Found");
                    }
                    break;
                }
                case 4: {
                    isValue = false;
                    break;
                }
                default: {
                    System.out.println("Enter the valid inputs...");
                }
            }
        }

    }
}
