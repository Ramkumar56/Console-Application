package view;

import Model.Account;
import Model.Customer;
import controller.AdminContoller;
import controller.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import static Model.DatabaseConnector.getConnection;

public class AdminView {
    private Scanner scanner = new Scanner(System.in);

    public boolean adminLogin(String adminId, String adminPassword) {
        AdminContoller adminContoller = new AdminContoller();
        try {
            Connection connection = getConnection();
            String query = "select adminid, password from admin where adminid=12345";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            String correctAdminId = result.getString("adminid");
            String correctAdminPassWord = result.getNString("password");
            if (correctAdminId.equals(adminId)) {
                if (correctAdminPassWord.equals(adminPassword)) {
                    boolean adminlogin = true;
                    while (adminlogin) {
                        System.out.println("\nEnter Your choice :\n1.View All User Details \n2.View All User Account Dewtails \n3.Remove User Account"
                                + "\n4.Search User Details \n5.Change Admin Password \n6.LogOut");
                        int adminChoice = scanner.nextInt();
                        switch (adminChoice) {
                            case 1:
                                ArrayList<Customer> allUserDetails = (ArrayList<Model.Customer>)adminContoller.allUserDetails();
                                System.out.println("\n***********************USER INFO***********************\n");
                                for(Customer customer : allUserDetails){
                                    if (customer.getName() != null) {
                                        System.out.println("\nCustomer ID      : " + customer.getName());
                                        System.out.println("Name             : " + customer.getName());
                                        System.out.println("Gender           : " + customer.getGender());
                                        System.out.println("Date of Birth    : " + customer.getDateOfBirth());
                                        System.out.println("Email            : " + customer.getEmail());
                                        System.out.println("Phone Number     : " + customer.getPhoneNumber());
                                        System.out.println("Account Type     : " + customer.getAccountType());
                                        System.out.println("City             : " + customer.getCity());
                                        System.out.println("Password         : " + customer.getPassword());
                                    }
                                }
                                break;
                            case 2: {
                                ArrayList<Account> allUserAccountDetails=adminContoller.allUserAccountDetails();
                                System.out.println("\n***********************ACCOUNT INFO***********************\n");
                                for(Account account:allUserAccountDetails){
                                    System.out.println("\nCustomer ID      : " + account.getCustomerid());
                                    System.out.println("Account Number   : " + account.getAccountnumber());
                                    System.out.println("Account Balance  : " + account.getAccountbalance());
                                    System.out.println("Account Status   : " + account.getAccountstatus());
                                }
                                break;
                            }
                            case 3:
                                boolean isCleanSlate = true;
                                while (isCleanSlate) {
                                    System.out.println("Enter customerID  For Remove Account : ");
                                    int customerId = scanner.nextInt();
                                    Customer cleanSlateCustomer = adminContoller.cleanSlate(customerId);
                                    if (cleanSlateCustomer.getName() != null) {
                                        System.out.println("\n***********************USER INFO***********************\n");
                                        System.out.println("Customer ID      : " + cleanSlateCustomer.getName());
                                        System.out.println("Name             : " + cleanSlateCustomer.getName());
                                        System.out.println("Gender           : " + cleanSlateCustomer.getGender());
                                        System.out.println("Date of Birth    : " + cleanSlateCustomer.getDateOfBirth());
                                        System.out.println("Email            : " + cleanSlateCustomer.getEmail());
                                        System.out.println("Phone Number     : " + cleanSlateCustomer.getPhoneNumber());
                                        System.out.println("Account Type     : " + cleanSlateCustomer.getAccountType());
                                        System.out.println("City             : " + cleanSlateCustomer.getCity());
                                        System.out.println("Password         : " + cleanSlateCustomer.getPassword());

                                        System.out.println("press 1 to confirm Delete");
                                        int confirm = scanner.nextInt();
                                        if (confirm == 1)
                                            adminContoller.deleteaccount(customerId);
                                    } else {
                                        System.out.println("\nDeletion Cancelled\n");
                                    }
                                }
                                break;
                            case 4:
                                AdminControllView adminControllView = new AdminControllView();
                                adminControllView.toSearchUserDetails();
                                break;
                            case 5:
                                boolean value2 = true;
                                while (value2) {
                                    System.out.println("\nEnter New PassWord : ");
                                    String newPassWord = scanner.next();
                                    System.out.println("\nConfirm New PassWord : ");
                                    String confirmPassWord = scanner.next();
                                    if (newPassWord.equals(confirmPassWord) && validation.isValidPassword(confirmPassWord)) {
                                        adminContoller.toChangeAdminPassWord(adminId, confirmPassWord);
                                        System.out.println("\nUpdate Completed\n");
                                        value2 = false;
                                    } else {
                                        System.out.println("\nNot Updated...\n");
                                        System.out.println("Enter Valid PassWord...");
                                    }
                                }
                                break;
                            case 6:
                                adminlogin = false;
                                break;
                            default:
                                System.out.println("Enter valid inputs...\n");
                        }
                    }
                } else {
                    System.out.println("Please Enter Valid Admin Password...");
                    return false;
                }
            } else {
                System.out.println("Please Enter Valid AdminId...");
                return false;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}

