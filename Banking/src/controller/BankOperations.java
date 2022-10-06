package controller;

import Admin.Admin;
import User.User;
import entites.Customer;
import entites.CustomerOperations;

import java.text.ParseException;
import java.util.Scanner;

public class BankOperations {
    public static void main(String[] args) throws ParseException {
        Scanner input= new Scanner(System.in);
        CustomerOperations customerop=new CustomerOperations();
        Customer customer=new Customer();
        Admin admin=new Admin();
        User user=new User();
        boolean ch=true;
        while(ch){
            System.out.println("\t1.Create Account\n\t2.Manage Account\n\t3.Exit");
            int choice= input.nextInt();
            switch (choice) {
                case 1: {
                    customerop.createAccount();
                    break;
                }
                case 2: {
                    boolean value=true;
                    while (value){
                        System.out.println("\nEnter Your Choice : \n1.Admin \n2.Customer \n3.Back ");
                        int choice1 =input.nextInt();
                        switch (choice1){
                            case 1:{
                                System.out.println("Enter the Admin Id:");
                                String adminId= input.next();
                                System.out.println("Enter Admin Password : ");
                                String adminPassword=input.next();
                                admin.adminLogin(adminId,adminPassword);
                                break;
                            }
                            case 2:{
                                System.out.println("Enter the customerId ");
                                String customerId=input.next();
                                System.out.println("Enter the password ");
                                String password=input.next();
                                user.user(customerId,password);
                                break;
                            }
                            case 3:{
                                value=false;
                                break;
                            }
                        }
                    }
                }
                case 3:{
                    ch=false;
                    break;
                }
            }
        }
    }
}
