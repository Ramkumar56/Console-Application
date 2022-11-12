package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeView {
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        try {
            Boolean homeviewcheck = true;
            do {
                System.out.println("Enter the choice\n1.Admin \n2.User \n3.Logout");
                int value = scanner.nextInt();
                switch (value) {
                    case 1:
                        AdminView adminView = new AdminView();
                        adminView.init();
                        break;
                    case 2:
                        UserView userView = new UserView();
                        userView.init();
                }

            } while (homeviewcheck);
        }catch (InputMismatchException e){
            System.out.println("Enter the valid inputs...");
        }

    }


    public static void main(String[] args) {
        HomeView homeView = new HomeView();
        homeView.init();
    }

}
