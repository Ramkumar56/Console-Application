package controller;

import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import static Model.DatabaseConnector.getConnection;

public class UserController {
    Scanner scanner = new Scanner(System.in);

    public boolean userLogin(String customerId, String password) {
        try {
           Connection connection = getConnection();
            String query = "select customerid, userpassword from customerdetails where customerid=" + customerId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            String correctUserId = result.getString("customerid");
            String correctUserPassWord = result.getNString("userpassword");
            if (correctUserId.equals(correctUserId)) {
                if (correctUserPassWord.equals(password)) {
                    return true;
                } else {
                    System.out.println("Please Enter Valid  Password...");
                    return false;
                }
            } else {
                System.out.println("Please Enter Valid ...");
                return false;
            }


        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }


    public Account accountview(String customerId) {
        Account account=null;
        try {
           Connection connection = getConnection();
            String query = "select * from accountdetails where customerid = " + "'" + customerId + "'";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                account=new Account();
                account.setCustomerid(Integer.parseInt(result.getString("customerid")));
                account.setAccountnumber(result.getString("accountnumber"));
                account.setAccountbalance(Long.parseLong(result.getString("accountbalance")));
                account.setAccountstatus(result.getString("accountstatus"));
                return account;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return account;
    }

    public Customer customerDetail(String customerId) {
        Customer customer=null;
        try {
            Connection connection = getConnection();
            String query = "select * from customerdetails where customerid=" + customerId;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
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
                return customer;

            }
        } catch (Exception e) {
            return customer;
        }
        return customer;
    }

    public void deposite(String customerId) {
        boolean check = true;
        Connection connection = getConnection();
        while (check) {
            System.out.println("\nEnter Amount to Deposit : ");
            long amount = scanner.nextInt();
            try {
                String transactinType = String.valueOf(TransactionType.Deposit);
                String query = "select accountbalance from accountdetails where customerid=" + customerId;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet result = preparedStatement.executeQuery();
                result.next();
                String accountBalance = result.getString("accountbalance");
                if (100000 > Integer.parseInt(accountBalance)) {
                    System.out.println("Your Deposite Amount is : " + amount);
                    amount = amount + Integer.parseInt(accountBalance);
                    query = "update accountdetails set accountbalance = " + amount + " where customerid=" + customerId;
                    preparedStatement = connection.prepareStatement(query);
                    int x = preparedStatement.executeUpdate();
                    if (x == 1) {
                        if (toUpdateTransactionTable(customerId, transactinType, amount)) {
                            System.out.println("Your Balance Amount is : " + amount);
                        } else {
                            System.out.println("\ntransaction Details Error...\n");
                        }
                        check = false;
                    }
                } else {
                    System.out.println("Your Deposite amount is more than 1 Lakh So Please Enter Pan Details : ");
                    String panCard = scanner.next();
                    if (validation.isValidPanCard(panCard)) {
                        System.out.println("Your Deposite Amount is : " + amount);
                        amount = amount + Integer.parseInt(accountBalance);
                        query = "update accountdetails set accountbalance = " + amount + " where customerid=" + customerId;
                        preparedStatement = connection.prepareStatement(query);
                        int x = preparedStatement.executeUpdate();
                        if (x == 1) {
                            if (toUpdateTransactionTable(customerId, transactinType, amount)) {
                                System.out.println("Your Balance Amount is : " + amount);
                                check = false;
                            } else {
                                System.out.println("\ntransaction Details Error...\n");
                            }
                        }
                    } else {
                        System.out.println("\nYour PanCard Number is Invalid...\n");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public void withDrawAmount(String customerId) {
        boolean check = true;
        Connection connection = getConnection();
        TransactionType transactionType = null;
        while (check) {
            System.out.println("\nEnter Amount to WithDraw : ");
            long amount = scanner.nextInt();
            try {
                String query = "select accountbalance from accountdetails where customerid=" + customerId;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet result = preparedStatement.executeQuery();
                result.next();
                transactionType = TransactionType.Withdrawn;
                String accountBalance = result.getString("accountbalance");
                if (100000 > Integer.parseInt(accountBalance)) {
                    if (amount < Integer.parseInt(accountBalance)) {
                        System.out.println("Your WithDrawn Amount is : " + amount);
                        amount = Integer.parseInt(accountBalance) - amount;
                        query = "update accountdetails set accountbalance = " + amount + " where customerid=" + customerId;
                        preparedStatement = connection.prepareStatement(query);
                        int x = preparedStatement.executeUpdate();
                        if (x == 1) {
                            if (toUpdateTransactionTable(customerId, String.valueOf(transactionType), amount)) {
                                System.out.println("Your Balance Amount is : " + amount);
                            } else {
                                System.out.println("\ntransaction Details Error...\n");
                            }
                            check = false;
                        }
                    } else {
                        System.out.println("\nInsufficient Funds...\n");
                    }
                }


            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private boolean toUpdateTransactionTable(String customerId, String transactionType, long amount) {
        try {
            Connection connection = getConnection();
            String dateOfTransaction = "" + LocalDate.now();
            String query = "insert into transactionsdetails(customerid, dateoftransaction, transactiontype, transactionamount) "
                    + "Values(" + "'" + customerId + "', " + "'" + dateOfTransaction + "', " + "'" + transactionType + "', "
                    + "'" + amount + "'" + ")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int x = preparedStatement.executeUpdate();
            if (x == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return true;
    }

    public Transaction viewTransactions(String customerId) {
        Transaction transaction=null;
        try {
            Connection connection=getConnection();
            String query = "select * from transactionsdetails where customerid = " + customerId;
           PreparedStatement preparedStatement =  connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
                transaction = new Transaction();
                transaction.setCustomerid(Integer.parseInt(result.getString("customerid")));
                transaction.setDateOfTransaction(result.getString("dateoftransaction"));
                transaction.setTransactionType(result.getString("transactiontype"));
                transaction.setTransactionAmount(result.getString("transactionamount"));
                return transaction;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return transaction;
    }
}
