package User;

import Enums.TransactionType;
import validation.validation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import static DbConnector.DbConnector.CreateMyConnection;

public class UserController {
    Scanner input = new Scanner(System.in);
    Connection con =null;
    ResultSet result;
    PreparedStatement psmt =null;
    public boolean userLogin(String customerId, String password) {
        try {
            con = CreateMyConnection();
            String str ="select customerid, userpassword from customerdetails where customerid="+customerId;
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            result.next();
            String correctUserId = result.getString("customerid");
            String correctUserPassWord = result.getNString("userpassword");
            if(correctUserId.equals(correctUserId)) {
                if(correctUserPassWord.equals(password)) {
                    return true;
                }
                else {
                    System.out.println("Please Enter Valid  Password...");
                    return false;
                }
            }
            else {
                System.out.println("Please Enter Valid ...");
                return false;
            }


        }catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public void viewUser(String customerId) {
        boolean value=true;
        while(value){
            System.out.println("\nEnter You Want to do  \n1.Customer Detail"
                    + "\n2.User Account Details \n3.User Transactions Details \n4.Back ");
            int choice=input.nextInt();
            switch(choice){
                case 1:{
                    if (customerDetail(customerId))
                        value=false;
                    else
                        System.out.println("CustomerId Not found...");
                    break;
                }
                case 2:{
                    view(customerId);
                    break;
                }
                case 3:{
                      userTransactionsDetails(customerId);
                    break;
                }
            }
        }

    }

    private void userTransactionsDetails(String customerId) {

    }

    private void view(String customerId) {
        try {
            con = CreateMyConnection();
            String str ="select * from accountdetails where customerid = "+"'"+customerId+"'";
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            while (result.next()) {
                System.out.println("\n***********************ACCOUNT INFO***********************\n");
                System.out.println("Customer ID      : "+result.getString("customerid"));
                System.out.println("Account Number   : "+result.getString("accountnumber"));
                System.out.println("Account Balance  : "+result.getString("accountbalance"));
                System.out.println("Account Status   : "+result.getString("accountstatus"));
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    private boolean customerDetail(String customerId) {
        try {
            con = CreateMyConnection();
            String str ="select * from customerdetails where customerid="+customerId;
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            while (result.next()) {
                System.out.println("\n***********************USER INFO***********************\n");
                System.out.println("Customer ID      : "+result.getString("customerid"));
                System.out.println("Name             : "+result.getString("username"));
                System.out.println("Gender           : "+result.getString("gender"));
                System.out.println("Date of Birth    : "+result.getString("dateofbirth"));
                System.out.println("Email            : "+result.getString("email"));
                System.out.println("Phone Number     : "+result.getString("phonenumber"));
                System.out.println("Account Type     : "+result.getString("accounttype"));
                System.out.println("City             : "+result.getString("city"));
                System.out.println("PassWord         : "+result.getString("userpassword"));

            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

    public void deposite(String customerId) {
        boolean check=true;
        con = CreateMyConnection();
        while(check) {
            System.out.println("\nEnter Amount to Deposit : ");
            long amount=input.nextInt();
            try {
                String transactinType= String.valueOf(TransactionType.Deposit);
                String str ="select accountbalance from accountdetails where customerid="+customerId;
                psmt = con.prepareStatement(str);
                result=psmt.executeQuery();
                result.next();
                String accountBalance = result.getString("accountbalance");
                if(100000>Integer.parseInt(accountBalance)) {
                    System.out.println("Your Deposite Amount is : "+amount);
                    amount=amount+Integer.parseInt(accountBalance);
                    str = "update accountdetails set accountbalance = "+amount+" where customerid="+customerId;
                    psmt = con.prepareStatement(str);
                    int x = psmt.executeUpdate();
                    if (x == 1) {
                        if(toUpdateTransactionTable(customerId, transactinType, amount)) {
                            System.out.println("Your Balance Amount is : "+amount);
                        }
                        else {
                            System.out.println("\ntransaction Details Error...\n");
                        }
                        check=false;
                    }
                }
                else {
                    System.out.println("Your Deposite amount is more than 1 Lakh So Please Enter Pan Details : ");
                    String panCard = input.next();
                    if(validation.isValidPanCard(panCard)) {
                        System.out.println("Your Deposite Amount is : "+amount);
                        amount=amount+Integer.parseInt(accountBalance);
                        str = "update accountdetails set accountbalance = "+amount+" where customerid="+customerId;
                        psmt = con.prepareStatement(str);
                        int x = psmt.executeUpdate();
                        if (x == 1) {
                            if(toUpdateTransactionTable(customerId, transactinType, amount)) {
                                System.out.println("Your Balance Amount is : "+amount);
                                check=false;
                            }
                            else {
                                System.out.println("\ntransaction Details Error...\n");
                            }
                        }
                    }
                    else {
                        System.out.println("\nYour PanCard Number is Invalid...\n");
                    }
                }
            }catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public void withDrawAmount(String customerId) {
        boolean check=true;
        con = CreateMyConnection();
        TransactionType transactionType=null;
        while(check) {
            System.out.println("\nEnter Amount to WithDraw : ");
            long amount=input.nextInt();
            try {
                String str ="select accountbalance from accountdetails where customerid="+customerId;
                psmt = con.prepareStatement(str);
                result=psmt.executeQuery();
                result.next();
               transactionType= TransactionType.Withdrawn;
                String accountBalance = result.getString("accountbalance");
                if(100000>Integer.parseInt(accountBalance)) {
                    if(amount<Integer.parseInt(accountBalance)) {
                        System.out.println("Your WithDrawn Amount is : "+amount);
                        amount=Integer.parseInt(accountBalance)-amount;
                        str = "update accountdetails set accountbalance = "+amount+" where customerid="+customerId;
                        psmt = con.prepareStatement(str);
                        int x = psmt.executeUpdate();
                        if (x == 1) {
                            if(toUpdateTransactionTable(customerId, String.valueOf(transactionType), amount)) {
                                System.out.println("Your Balance Amount is : "+amount);
                            }
                            else {
                                System.out.println("\ntransaction Details Error...\n");
                            }
                            check=false;
                        }
                    }
                    else {
                        System.out.println("\nYour WithDrawn Amount is must be less than Available Balance...\n");
                    }
                }


            }catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    private boolean toUpdateTransactionTable(String customerId, String transactionType, long amount) {
        try {
            con = CreateMyConnection();
            String dateOfTransaction = ""+ LocalDate.now();
            String str = "insert into transactionsdetails(customerid, dateoftransaction, transactiontype, transactionamount) "
                    + "Values(" + "'" + customerId + "', "+"'"+dateOfTransaction+"', "+"'" + transactionType + "', "
                    + "'" + amount +"'"+")";
            psmt = con.prepareStatement(str);
            int x = psmt.executeUpdate();
            if(x == 1) {
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return true;
    }

    public void viewTransactions(String customerId) {
        try {
           String str="select * from transactionsdetails where customerid = "+customerId;
            int count=0;
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            System.out.println("\n***********************TRANSACTION INFO***********************\n");
            while(result.next()) {
                count++;
                System.out.println("Customer Id          : "+result.getString("customerid"));
                System.out.println("Date of Transaction  : "+result.getString("dateoftransaction"));
                System.out.println("Transaction Type     : "+result.getString("transactiontype"));
                System.out.println("Transaction Amount   : "+result.getString("transactionamount"));
                System.out.println();
            }
            if(count==0) {
                System.out.println("\nNo Transaction Found\n");
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
