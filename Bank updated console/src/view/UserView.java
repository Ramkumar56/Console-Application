package view;

import controller.UserController;

import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);

    public void user(String customerId, String password) {
        UserController userController = new UserController();
        if (userController.userLogin(customerId, password)) {
            boolean userLogin = true;
            while (userLogin) {
                System.out.println("\nEnter Your choice :\n1.View Your Persional Details "
                        + "\n2.Deposite Amount \n3.WithDraw Amount \n4.View Transaction \n5.LogOut");
                int userChoice = scanner.nextInt();
                switch (userChoice) {
                    case 1: {
                        UserControllView userControllView =new UserControllView();
                        userControllView.viewUser(customerId);
                        break;
                    }
                    case 2: {
                        userController.deposite(customerId);
                        break;
                    }
                    case 3: {
                        userController.withDrawAmount(customerId);
                        break;
                    }
                    case 4: {
                        userController.viewTransactions(customerId);
                        break;
                    }
                    case 5: {
                        userLogin = false;
                        break;
                    }
                    default: {
                        System.out.println("Enter the valid inputs...");
                    }
                }
            }

        }
    }


}
