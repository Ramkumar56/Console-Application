package entites;

import Enums.AccountType;

public class Customer {
    private int customerid;
    private String name;
    private String phoneNumber;
    private String dateOfBirth;
    private String gender;
    private String city;
    private String email;
    private AccountType accountType;
    private long balance;
    private String aadharNumber;
    private String panNumber;
    private String accountStatus;
    private String password;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNo) {
        this.phoneNumber = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAdharNo() {
        return aadharNumber;
    }

    public void setAdharNo(String adharNo) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNo() {
        return panNumber;
    }

    public void setPanNo(String panNo) {
        this.panNumber = panNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
