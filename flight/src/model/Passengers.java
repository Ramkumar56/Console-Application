package model;

public class Passengers {
    private String name;
    private int PassportNumber;
    private int userId;
    private int bookedTicketsPerPassengers;
    private int passengerCost;
    private String password;
private int passengerId;


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

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setPassengerCost(int passengerCost) {
        this.passengerCost = passengerCost;

    }
}
