package view;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner = new Scanner(System.in);
    public void manage() {
        boolean clientLogin = true;
        while (clientLogin) {
            System.out.println("\nEnter Your Choice : \n1.Admin \n2.Customer \n3.Back ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the Admin Id:");
                    String adminId = scanner.next();
                    System.out.println("Enter Admin Password : ");
                    String adminPassword = scanner.next();
                    AdminView adminView = new AdminView();
                    adminView.adminLogin(adminId, adminPassword);
                    break;
                }
                case 2: {
                    System.out.println("Enter the customerId ");
                    String customerId = scanner.next();
                    System.out.println("Enter the password ");
                    String password = scanner.next();
                    UserView userView = new UserView();
                    userView.user(customerId, password);
                    break;
                }
                case 3: {
                    clientLogin = false;
                    break;
                }
            }
        }
    }
}
