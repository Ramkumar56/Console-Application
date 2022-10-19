package controller;

import Model.Account;
import Model.AccountType;
import Model.Customer;
import Model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static Model.DatabaseConnector.getConnection;

public class AdminContoller {
    public Customer cleanSlate(int customerId) {
        Customer customer=new Customer();
        try {
            Connection connection = getConnection();
            String query = "select * from customerdetails where customerid = " + customerId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            customer = new Customer();
            customer.setCustomerid(Integer.parseInt(result.getString("customerid")));
            customer.setName(result.getString("username"));
            customer.setGender(result.getString("gender"));
            customer.setDateOfBirth(result.getString("dateofbirth"));
            customer.setEmail(result.getString("email"));
            customer.setPhoneNumber(result.getString("phonenumber"));
            customer.setAccountType(AccountType.valueOf(result.getString("accounttype")));
            customer.setCity(result.getString("city"));
            customer.setPassword(result.getString("userpassword"));
            return customer;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return customer;
    }

    public boolean deleteaccount(int adminId) {
        try {
            Connection connection = getConnection();
            String query = "select * from customerdetails where customerid = " + adminId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            query = "delete from transactionsdetails where customerid = " + adminId;
            preparedStatement = connection.prepareStatement(query);
            int x = preparedStatement.executeUpdate();
            if (x == 0) {
                x = 1;
            }
            if (x == 1) {
                query = "delete from customerdetails where customerid = " + adminId;
                preparedStatement = connection.prepareStatement(query);
                x = preparedStatement.executeUpdate();
                if (x == 1) {
                    query = "delete from accountdetails where customerid = " + adminId;
                    preparedStatement = connection.prepareStatement(query);
                    x = preparedStatement.executeUpdate();
                    if (x == 1) {
                        System.out.println("\nDeletion Completed\n");
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public List<Customer> allUserDetails() {
        Customer customer = null;
        List<Customer> customerList=new ArrayList<>();
        try {
            Connection connection = getConnection();
            String query;
                    query = "SELECT COUNT(*) FROM customerdetails";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    ResultSet result = preparedStatement.executeQuery();
                    query = "select * from customerdetails";
                    preparedStatement = connection.prepareStatement(query);
                    result = preparedStatement.executeQuery();
                    while (result.next()) {
                        customer = new Customer();
                        customer.setCustomerid(Integer.parseInt(result.getString("customerid")));
                        customer.setName(result.getString("username"));
                        customer.setGender(result.getString("gender"));
                        customer.setDateOfBirth(result.getString("dateofbirth"));
                        customer.setEmail(result.getString("email"));
                        customer.setPhoneNumber(result.getString("phonenumber"));
                        customer.setAccountType(AccountType.valueOf(result.getString("accounttype")));
                        customer.setCity(result.getString("city"));
                        customer.setPassword(result.getString("userpassword"));
                        customerList.add(customer);
                    }
                    return customerList;

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return (ArrayList<Customer>) customerList;
    }

    public ArrayList<Account> allUserAccountDetails () {
        Connection connection=getConnection();
        ResultSet result;
        PreparedStatement preparedStatement;
        String query;
        query = "SELECT COUNT(*) FROM accountdetails";
        Account accounts =null;
        List<Account> accountList=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            query = "select * from accountdetails";
            preparedStatement = connection.prepareStatement(query);
            result = preparedStatement.executeQuery();
            while (result.next()) {
                accounts = new Account();
                accounts.setCustomerid(Integer.parseInt(result.getString("customerid")));
                accounts.setAccountnumber(result.getString("accountnumber"));
                accounts.setAccountbalance(Long.parseLong(result.getString("accountbalance")));
                accounts.setAccountstatus(result.getString("accountstatus"));
                accountList.add(accounts);
            }
            return (ArrayList<Account>) accountList;
        }
            catch (Exception e) {
                System.out.println(e.toString());
        }
        return (ArrayList<Account>) accountList;
    }


    public ArrayList<Transaction> viewUserTransactionDeatails(String query) {
        Transaction transaction = null;
        ArrayList<Transaction>transactionArrayList=new ArrayList<Transaction>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                transaction = new Transaction();
                transaction.setCustomerid(Integer.parseInt(result.getString("customerid")));
                transaction.setDateOfTransaction(result.getString("dateoftransaction"));
                transaction.setTransactionType(result.getString("transactiontype"));
                transaction.setTransactionAmount(result.getString("transactionamount"));
                transactionArrayList.add(transaction);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return transactionArrayList;
    }

    public Account toSearch(String customerid) {
        Account account = new Account();
        try {
            Connection connection = getConnection();
            String query = "select * from accountdetails where customerid = " + "'" + customerid + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            account.setCustomerid(Integer.parseInt(result.getString("customerid")));
            account.setAccountnumber(result.getString("accountnumber"));
            account.setAccountbalance(Long.parseLong(result.getString("accountbalance")));
            account.setAccountstatus(result.getString("accountstatus"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return account;
    }

    public Customer toSearch(String info, int choice) {
        Customer customer = new Customer();
        if (choice == 1) {
            info = "username =" + "'" + info + "'";
        } else {
            info = "customerid=" + "'" + info + "'";
        }
        try {
            Connection connection = getConnection();
            String query = "select * from customerdetails where " + info;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                customer.setCustomerid(Integer.parseInt(result.getString("customerid")));
                customer.setName(result.getString("username"));
                customer.setGender(result.getString("gender"));
                customer.setDateOfBirth(result.getString("dateofbirth"));
                customer.setEmail(result.getString("email"));
                customer.setPhoneNumber(result.getString("phonenumber"));
                customer.setAccountType(AccountType.valueOf(result.getString("accounttype")));
                customer.setCity(result.getString("city"));
                customer.setPassword(result.getString("userpassword"));
                return customer;

            }
        } catch (Exception e) {
            return customer;
        }
        return customer;
    }

    public boolean toChangeAdminPassWord(String adminId, String confirmPassWord) {
        try {
            Connection connection = getConnection();
            String query = "UPDATE admin SET password = " + "'" + confirmPassWord + "'" + " WHERE adminid = " + adminId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int x = preparedStatement.executeUpdate();
            if (x == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return true;
    }
}

