package view;

import Model.Account;
import Model.Customer;
import Model.Transaction;
import controller.AdminContoller;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminControllView {
    Scanner scanner = new Scanner(System.in);

    public void toSearchUserDetails() {
        boolean isValue = true;
        int choice;
        AdminContoller adminContoller = new AdminContoller();
        while (isValue) {
            System.out.println("\nEnter You Want to Do \n1.Search by Name \n2.Search by Customer ID "
                    + "\n3.User Account Details \n4.User Transactions Details \n5.Back ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("\nEnter Name to Search : ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    //if (adminContoller.toSearch(name, choice)) {
                    Customer customer = adminContoller.toSearch(name, choice);
                    if (customer.getCustomerid() != 0) {
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
                    } else {
                        System.out.println("User Name Not Found...");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter the customerId ");
                    String customerid = scanner.next();
                    Customer customer = adminContoller.toSearch(customerid, choice);
                    // if (adminContoller.toSearch(customerid, choice)) {
                    if (customer.getCustomerid() != 0) {
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
                    } else {
                        System.out.println("User Name Not Found...");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the CustomerId");
                    String customerid = scanner.next();
                    Account account = adminContoller.toSearch(customerid);
                    System.out.println("\n***********************ACCOUNT INFO***********************\n");
                    System.out.println("Customer ID      : " + account.getCustomerid());
                    System.out.println("Account Number   : " + account.getAccountnumber());
                    System.out.println("Account Balance  : " + account.getAccountbalance());
                    System.out.println("Account Status   : " + account.getAccountstatus());
                    break;
                }
                case 4: {
                    userTransactionsDetails();
                    break;
                }
                case 5: {
                    isValue = false;
                    break;
                }
                default:
                    System.out.println("\nEnter valid inputs...\n");
            }

        }

    }

    public void userTransactionsDetails() {
        boolean check = true;
        String query = "";
        while (check) {
            System.out.println("\nEnter Your Choice \n1.All User Details \n2.Single User Details \n3.Back ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    query = "select * from transactionsdetails";
                    AdminContoller adminContoller = new AdminContoller();
                    ArrayList<Transaction> transactionArrayList = adminContoller.viewUserTransactionDeatails(query);
                    System.out.println("\n***********************TRANSACTION INFO***********************\n");
                    for(Transaction transaction:transactionArrayList){
                        System.out.println("Customer Id          : " + transaction.getCustomerid());
                        System.out.println("Date of Transaction  : " + transaction.getDateOfTransaction());
                        System.out.println("Transaction Type     : " + transaction.getTransactionType());
                        System.out.println("Transaction Amount   : " + transaction.getTransactionAmount());
                    }
                    check = false;
                    break;
                }
                case 2: {
                    System.out.println("\nEnter Customer Id : ");
                    String custId = scanner.next();
                    query = "select * from transactionsdetails where customerid = " + custId;
                    AdminContoller adminContoller = new AdminContoller();
                    ArrayList<Transaction> transaction =adminContoller.viewUserTransactionDeatails(query);
                    System.out.println("\n***********************TRANSACTION INFO***********************\n");
                    for(Transaction transactionList:transaction) {
                        if (transaction != null) {
                            System.out.println("Customer Id          : " + transactionList.getCustomerid());
                            System.out.println("Date of Transaction  : " + transactionList.getDateOfTransaction());
                            System.out.println("Transaction Type     : " + transactionList.getTransactionType());
                            System.out.println("Transaction Amount   : " + transactionList.getTransactionAmount());
                            check = false;
                        } else {
                            System.out.println("No Transaction Found");
                        }
                    }
                    break;
                }
                case 3: {
                    check = false;
                    break;
                }
                default:
                    System.out.println("\nEnter Valid Input...\n");
            }
        }
    }
}
