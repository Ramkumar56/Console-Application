package Admin;

import validation.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static DbConnector.DbConnector.CreateMyConnection;

public class Admin {
    Scanner input = new Scanner(System.in);
    Connection con = CreateMyConnection();
    ResultSet result;
    PreparedStatement psmt = null;
    boolean check = true;
    AdminContoller adminContoller = new AdminContoller();

    public boolean adminLogin(String adminId, String adminPassword) {
        try {
            con = CreateMyConnection();
            String str = "select adminid, password from admin where adminid=12345";
            psmt = con.prepareStatement(str);
            result = psmt.executeQuery();
            result.next();
            String correctAdminId = result.getString("adminid");
            String correctAdminPassWord = result.getNString("password");
            if (correctAdminId.equals(adminId)) {
                if (correctAdminPassWord.equals(adminPassword)) {
                    boolean value = true;
                    while (value) {
                        System.out.println("\nEnter Your choice :\n1.View All User Details \n2.Remove User Account"
                                + "\n3.Search User Details \n4.Change Admin Password \n5.LogOut");
                        int choice = input.nextInt();
                        switch (choice) {
                            case 1:
                                adminContoller.allUserDetails();
                                break;
                            case 2:
                                boolean value1 = true;
                                while (value1) {
                                    System.out.println("Enter customerID  For Remove Account : ");
                                    String accountNumber = input.next();
                                    int number = Integer.parseInt(accountNumber);
                                    if (adminContoller.toRemoveUserAccount(number)) {
                                        value1 = false;
                                    }
                                }
                                break;
                            case 3:
                                adminContoller.toSearchUserDetails();
                                break;
                            case 4:
                                boolean value2 = true;
                                while (value2) {
                                    System.out.println("\nEnter New PassWord : ");
                                    String newPassWord = input.next();
                                    System.out.println("\nConfirm New PassWord : ");
                                    String confirmPassWord = input.next();
                                    if (newPassWord.equals(confirmPassWord) && validation.isValidPassword(confirmPassWord)) {
                                        adminContoller.toChangeAdminPassWord(adminId, confirmPassWord);
                                        value2 = false;
                                    } else {
                                        System.out.println("Enter Valid PassWord...");
                                    }
                                }
                                break;
                            case 5:
                                value = false;
                                break;
                            default:
                                System.out.println("Enter valid choice...\n");
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

