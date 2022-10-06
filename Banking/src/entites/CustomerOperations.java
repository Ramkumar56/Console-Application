package entites;

import Enums.AccountType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import static DbConnector.DbConnector.CreateMyConnection;
import static validation.validation.*;

public class CustomerOperations {
Scanner input = new Scanner(System.in);
Connection con = CreateMyConnection();
ResultSet result;
PreparedStatement psmt = null;
boolean check=true;
public void createAccount() throws ParseException {
    Customer customer = new Customer();
    System.out.println("Enter the name ");
    String name = input.next();
    customer.setName(name);

    while (check == true) {
        System.out.println("\nEnter Your Birth ");
        System.out.println("Enter Year : ");
        int year = input.nextInt();
        System.out.println("Enter Month : ");
        int month = input.nextInt();
        System.out.println("Enter Date : ");
        int date = input.nextInt();
        String dob = "" + year + "-" + month + "-" + date;

        if (year > 1950 && year < Calendar.getInstance().get(Calendar.YEAR) - 18) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(dob);
            customer.setDateOfBirth(dob);
            check = false;
        } else {
            System.out.println("\ninvalid date ");
        }
    }
    check = true;
    while (check == true) {
        System.out.println("Enter Gender(M-Male, F-Female, T-Trangender : ");
        String gender = "" + input.next().toUpperCase().charAt(0);
        if (gender.equals("M") || gender.equals("F") || gender.equals("T")) {
            customer.setGender(gender);
            check = false;
        } else {
            System.out.println("\nEnter Valid Details...");
        }
    }
    check = true;
    while (check != false) {
        System.out.println("Enter Email : ");
        String email = input.next();
        boolean val = isValidEmail(email);
        if (val) {
            customer.setEmail(email);
            check = false;
        } else {
            System.out.println("Enter Valid Email id...");
        }
    }

    check = true;
    while (check == true) {
        System.out.println("Enter PassWord : ");
        String passWord = input.next();
        boolean val = isValidPassword(passWord);
        if (val) {
            customer.setPassword(passWord);
            check = false;
        } else {
            System.out.println("Create PassWord(8 to 12) digits using numbers, "
                    + "characters(upper,lower), one symbol must(!@#$%&*()-+=^.),...");
        }
    }

    check = true;
    while (check != false) {
        System.out.println("Enter phone Number : ");
        String number = input.next();
        boolean val = isValidPhoneNumber(number);
        if (val) {
            customer.setPhoneNumber(number);
            check = false;
        } else {
            System.out.println("Enter Valid Phone Number...");
        }
    }


    check = true;
    int warning = 0;
    AccountType accountType = null;
    while (check) {
        System.out.println("Enter choices \n1.Savings \n2.Current \n");
        int ch = input.nextInt();
        long balance=0;
        switch (ch) {
            case 1: {
                System.out.println("Enter the minimum Account Balance ");
                balance = input.nextLong();
                accountType = AccountType.SAVING;
                break;
            }
            case 2: {
                System.out.println("Enter the minimum Account Balance ");
                balance = input.nextLong();
                accountType = AccountType.CURRENT;
                break;
            }
        }
            customer.setBalance(balance);
            check = false;
    }
    input.nextLine();
    System.out.println("Enter City : ");
    String city = input.nextLine().toLowerCase();
    customer.setCity(city);
    customer.setAccountType(accountType);
    try {
        con = CreateMyConnection();
        String str ="insert into customerdetails(username, gender, dateofbirth, email, phonenumber, accounttype, city, userpassword) "
                + "Values(" + "'" + customer.getName() + "', " + "'" + customer.getGender() + "', "
                + "'" + customer.getDateOfBirth() + "', " + "'" + customer.getEmail() + "', " + "'" + customer.getPhoneNumber() + "', "
                + "'" + customer.getAccountType()+ "', " + "'" + customer.getCity() + "', " + "'"
                + customer.getPassword() + "'" + ")";
        psmt = con.prepareStatement(str);

        int x = psmt.executeUpdate();
        if (x == 1) {
            str="select customerid from customerdetails where phonenumber="+customer.getPhoneNumber();
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            result.next();
            customer.setCustomerid(Integer.parseInt(result.getString("customerid")));
            customer.setAccountStatus("Active");
            str="insert into accountdetails(customerid,  accountbalance, accountstatus) "
                    + "Values(" +"'" + customer.getCustomerid() + "', " +"'" + customer.getBalance() + "', "
                    + "'" +customer.getAccountStatus() +"'"+")";
            psmt = con.prepareStatement(str);
            x = psmt.executeUpdate();
            if(x == 1) {
                str="select accountnumber from accountdetails where customerid="+customer.getCustomerid();
                psmt = con.prepareStatement(str);
                result=psmt.executeQuery();
                result.next();
                System.out.println("\nYour Account is Successfully Opened\n"
                        + "Your Account Number is : "+ result.getString("accountnumber")+"\n"
                        + "Your Customer ID is : "+customer.getCustomerid());
            }
        }

    }catch (Exception e) {
        System.out.println(e.toString());
    }
}


}