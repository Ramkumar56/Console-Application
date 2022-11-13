package view;

import model.Database;
import model.Flight;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HomeView {
    private Scanner scanner = new Scanner(System.in);

    static {
        List<String>route1=new ArrayList<>();
        route1.add("Chennai");
        route1.add("Bengaluru");
        route1.add("Kolkata");
        route1.add("Assam");
        List<String>route2=new ArrayList<>();
        route2.add("Chennai");
        route2.add("Bengaluru");
        route2.add("Mumbai");
        route2.add("Delhi");
        Flight flight=new Flight("Air India",1234,"12:00","06:00",route1,10,600);
        Database database=new Database();
        database.addFlight(flight,1234);
        Flight flight1=new Flight("Indigo",2345,"01:00","08:00",route2,15,800);
        database.addFlight(flight1,2345);

    }
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
