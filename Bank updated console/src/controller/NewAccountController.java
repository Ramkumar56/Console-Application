package controller;

import Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Scanner;

import static Model.DatabaseConnector.getConnection;

public class NewAccountController {
    Scanner input = new Scanner(System.in);
    public void createAccount(Customer customer) throws ParseException {

        try {
            Connection connection = getConnection();
            String query = "insert into customerdetails(username, gender, dateofbirth, email, phonenumber, accounttype, city, userpassword) "
                    + "Values(" + "'" + customer.getName() + "', " + "'" + customer.getGender() + "', "
                    + "'" + customer.getDateOfBirth() + "', " + "'" + customer.getEmail() + "', " + "'" + customer.getPhoneNumber() + "', "
                    + "'" + customer.getAccountType() + "', " + "'" + customer.getCity() + "', " + "'"
                    + customer.getPassword() + "'" + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            int x = preparedStatement.executeUpdate();
            if (x == 1) {
                query = "select customerid from customerdetails where phonenumber=" + customer.getPhoneNumber();
                preparedStatement = connection.prepareStatement(query);
                ResultSet result = preparedStatement.executeQuery();
                result.next();
                customer.setCustomerid(Integer.parseInt(result.getString("customerid")));
                customer.setAccountStatus("Active");
                query = "insert into accountdetails(customerid,  accountbalance, accountstatus) "
                        + "Values(" + "'" + customer.getCustomerid() + "', " + "'" + customer.getBalance() + "', "
                        + "'" + customer.getAccountStatus() + "'" + ")";
                preparedStatement = connection.prepareStatement(query);
                x = preparedStatement.executeUpdate();
                if (x == 1) {
                    query = "select accountnumber from accountdetails where customerid=" + customer.getCustomerid();
                    preparedStatement = connection.prepareStatement(query);
                    result = preparedStatement.executeQuery();
                    result.next();
                    System.out.println("\nYour Account is Successfully Opened\n"
                            + "Your Account Number is : " + result.getString("accountnumber") + "\n"
                            + "Your Customer ID is : " + customer.getCustomerid());
                }
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


}