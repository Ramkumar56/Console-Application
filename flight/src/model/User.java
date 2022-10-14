package model;

public class User {
    static int id=1111;
    private String name;
    private int PassportNumber;
    private int userId;
    private int bookedTicketsPerPassengers;
    private int passengerCost;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        PassportNumber = passportNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookedTicketsPerPassengers() {
        return bookedTicketsPerPassengers;
    }

    public void setBookedTicketsPerPassengers(int bookedTicketsPerPassengers) {
        this.bookedTicketsPerPassengers = bookedTicketsPerPassengers;
    }


    public int getPassengerCost() {
        return passengerCost;
    }

    public User(String name, String password, int userId) {
        id=id++;
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public void setPassengerCost(int passengerCost) {
        this.passengerCost = passengerCost;

    }
}
