package model;

public class Passenger {
    private String name;
    private int id;
    private int age;
    private String gender;

    private int flightId;

    public Passenger(String name, int id, int age, String gender,int flightId) {
        System.out.println(flightId);
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.flightId=flightId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
