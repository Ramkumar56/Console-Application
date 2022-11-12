package model;

public class UserDetails {
    private String name;
    private long phoneNumber;
    private static int userId=999;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public static void setUserId(int userId) {
        UserDetails.userId = userId;
    }

    public UserDetails(String name, long phoneNumber, String password, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userId = userId+1;
        this.password = password;
        this.email = email;
    }
}
