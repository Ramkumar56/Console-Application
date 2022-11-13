package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {

     public static HashMap<Integer,Flight>flightDatabase=new HashMap<>();

     public static List<Passenger>passengerList=new ArrayList<>();
     public static HashMap<Integer,List<Passenger>>bookedPassengers=new HashMap<>();
     public static HashMap<Integer,UserDetails>userDetails=new HashMap<>();

    public void addFlight(Flight flight, int flightId){
        flightDatabase.put(flightId,flight);

    }


    public void addPassengers(int pnrNumber, Passenger passenger) {
        passengerList.add(passenger);
        bookedPassengers.put(pnrNumber,passengerList);
    }

    public void addUserDetails(int userId,UserDetails userDetail) {
        userDetails.put(userId,userDetail);
    }

}
