package view;

import controller.AdminController;

import java.util.*;

public class AdminView {
    private Scanner scanner=new Scanner(System.in);
    public void init(){
        try {
            Boolean admincheck = true;
            do {
                System.out.println("Enter the username");
                String userName = scanner.next();
                System.out.println("Enter the password");
                String password = scanner.next();
                AdminView adminView = new AdminView();
                if (adminView.isValidAdmin(userName, password)) {
                    admincheck = false;
                    adminView.adminView();
                } else
                    System.out.println("Please enter the correct username and password");
            } while (admincheck);
        }catch (InputMismatchException e){
            System.out.println("Enter the valid inputs");
        }
    }

    private void adminView() {
        Boolean adminViewCheck=true;
        AdminView adminView=new AdminView();
        do {
            System.out.println("\n Enter the option \n1.Add Flight \n2.View Flight \n3.Remove Flight \n4.View Passengers");
            int value=scanner.nextInt();
            switch (value){
                case 1:
                    adminView.addflight();
            }
        }while (adminViewCheck);
    }

    private void addflight() {
        try {
            System.out.println("Enter the Flight Name ");
            String flightName = scanner.nextLine();
            System.out.println("Enter the Flight Id");
            int flightId = scanner.nextInt();
            System.out.println("Enter Departure Time");
            String departureTime = scanner.next();
            System.out.println("Enter Arrival Time");
            String arrivalTime = scanner.next();
            System.out.println("Enter the number of Seats");
            int seats = scanner.nextInt();
            System.out.println("Enter the price");
            int price = scanner.nextInt();
            System.out.println("Enter  the number of routes");
            int noRoutes = scanner.nextInt();
            List<String> routes = new ArrayList<>();
            for (int i = 1; i <= noRoutes; i++) {
                System.out.println("Enter the " + i + " city");
                routes.add(scanner.next());
            }
            AdminController adminController=new AdminController();
            adminController.addFlight(flightName,flightId,departureTime,arrivalTime,routes,seats,price);
        }catch (InputMismatchException e){
            System.out.println("Enter the valid inputs");
        }

    }

    private boolean isValidAdmin(String userName, String userpassword) {
        String name="Ram";
        String password="Ram123";
        if(userpassword.equals(password) && userName.equalsIgnoreCase(name)){
            return true;
        }
        return false;
    }
}
