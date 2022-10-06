package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static DbConnector.DbConnector.CreateMyConnection;

public class AdminContoller {
    Scanner input = new Scanner(System.in);
    Connection con = null;
    ResultSet result;
    PreparedStatement psmt = null;
    boolean check=true;

    public boolean toRemoveUserAccount(int adminId) {
        try {
            con = CreateMyConnection();
            String str ="select * from customerdetails where customerid = "+adminId;
            psmt = con.prepareStatement(str);
            result=psmt.executeQuery();
            result.next();
            System.out.println("\n***********************USER INFO***********************\n");
            System.out.println("Customer ID      : "+result.getString("customerid"));
            System.out.println("Name             : "+result.getString("username"));
            System.out.println("Gender           : "+result.getString("gender"));
            System.out.println("Date of Birth    : "+result.getString("dateofbirth"));
            System.out.println("Email            : "+result.getString("email"));
            System.out.println("Phone Number     : "+result.getString("phonenumber"));
            System.out.println("Account Type     : "+result.getString("accounttype"));
            System.out.println("City             : "+result.getString("city"));
            System.out.println("Password         : "+result.getString("userpassword"));

            System.out.println("press 1 to confirm Delete");
            int confirm = input.nextInt();
            if(confirm==1) {
               return deleteaccount(adminId);
            }
            else {
                System.out.println("\nDeletion Cancelled\n");
                return true;
                }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    private boolean deleteaccount(int adminId) {
        try {
            con = CreateMyConnection();
            String str = "select * from customerdetails where customerid = " + adminId;
            psmt = con.prepareStatement(str);
            result = psmt.executeQuery();
            result.next();
            str = "delete from transactionsdetails where customerid = " + adminId;
            psmt = con.prepareStatement(str);
            int x = psmt.executeUpdate();
            if (x == 1) {
                str = "delete from accountsdetails where customerid = " + adminId;
                psmt = con.prepareStatement(str);
                x = psmt.executeUpdate();
                if (x == 1) {
                    str = "delete from customerdetails where customerid = " + adminId;
                    psmt = con.prepareStatement(str);
                    x = psmt.executeUpdate();
                    if (x == 1) {
                        System.out.println("\nDeletion Completed\n");
                        return true;
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public void allUserDetails() {
        System.out.println("Enter Your Choice : \n1.Customer Personal Details"
                + "\n2.Customer Account Details : ");
        String choice=input.next();
        try {
            con = CreateMyConnection();
            String str ;
            switch(choice){
                case "1":
                    str = "SELECT COUNT(*) FROM customerdetails";
                    psmt = con.prepareStatement(str);
                    result=psmt.executeQuery();
                    str ="select * from customerdetails";
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
                    break;
                case "2":
                    str = "SELECT COUNT(*) FROM accountdetails";
                    psmt = con.prepareStatement(str);
                    result=psmt.executeQuery();
                    str ="select * from accountdetails";
                    psmt = con.prepareStatement(str);
                    result=psmt.executeQuery();
                    while (result.next()) {
                        System.out.println("\n***********************ACCOUNT INFO***********************\n");
                        System.out.println("Customer ID      : "+result.getString("customerid"));
                        System.out.println("Account Number   : "+result.getString("accountnumber"));
                        System.out.println("Account Balance  : "+result.getString("accountbalance"));
                        System.out.println("Account Status   : "+result.getString("accountstatus"));

                    }
                    break;
                default :
                    System.out.println("\nEnter Valid Input...\n");
            }

        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    public void toSearchUserDetails(){
        boolean value=true;
        int choice;
        while(value){
            System.out.println("\nEnter You Want to Do \n1.Search by Name \n2.Search by Customer ID "
                    + "\n3.User Account Details \n4.User Transactions Details \n5.Back ");
            choice = input.nextInt();
            
            switch (choice){
                case 1: {
                    System.out.println("\nEnter Name to Search : ");
                    input.nextLine();
                    String name=input.nextLine();
                    if(toSearch(name, choice)) {
                        value=false;
                    }
                    else {
                        System.out.println("User name Not Found...");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter the customerId ");
                    String customerid=input.next();
                    if(toSearch(customerid,choice)){
                        value=false;
                    }
                    else {
                        System.out.println("CustomerId Not found...");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the CustomerId");
                    String customerid=input.next();
                    toSearch(customerid);
                    break;
                }
                case 4:{
                    userTransactionsDetails();
                    break;
                }
                case 5:{
                    value=false;
                    break;
                }
                default:
                    System.out.println("\nEnter valid number...\n");
            }
            
        }
        
}

    private void userTransactionsDetails() {
        boolean check=true;
        String str="";
        while(check) {
            System.out.println("\nEnter Your Choice \n1.All User Details \n2.Single User Details \n3.Back ");
            int choice =input.nextInt();
            switch (choice){
                case 1:{
                     str="select * from transactionsdetails";
                    check=false;
                    break;
                }
                case 2:{
                    System.out.println("\nEnter Customer Id : ");
                    String custId=input.next();
                     str="select * from transactionsdetails where customerid = "+custId;
                    check=false;
                    break;
                }
                case 3:{
                    check=false;
                    break;
                }
                default:
                    System.out.println("\nEnter Valid Input...\n");
            }
            try {
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

    private void toSearch(String customerid) {
        try {
            con = CreateMyConnection();
            String str ="select * from accountdetails where customerid = "+"'"+customerid+"'";
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

    private boolean toSearch(String info, int choice) {
        if(choice==1){
            info="Name ="+"'"+info+"'";
        }
        else {
            info="customer Id="+"'"+info+"'";
        }
        try {
            con = CreateMyConnection();
            String str ="select * from customerdetails where "+info;
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

    public boolean toChangeAdminPassWord(String adminId, String confirmPassWord) {
        try {
            con = CreateMyConnection();
            String str ="UPDATE admin SET password = "+"'"+confirmPassWord+"'"+" WHERE adminid = "+adminId;
            psmt = con.prepareStatement(str);
            int x = psmt.executeUpdate();
            if (x == 1) {
                System.out.println("\nUpdate Completed\n");
                return true;
            }
            else {
                System.out.println("\nNot Updated...\n");
                return true;
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
        return true;
    }
}

