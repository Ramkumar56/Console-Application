package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import static DbConnector.DbConnector.CreateMyConnection;

public class User {
    Scanner input = new Scanner(System.in);
    Connection con = CreateMyConnection();
    ResultSet result;
    PreparedStatement psmt =null;
    UserController userController=new UserController();

    public void user(String customerId, String password) {
        if(userController.userLogin(customerId,password)){
            boolean value=true;
            while (value){
                System.out.println("\nEnter Your choice :\n1.View Your Persional Details "
                        + "\n2.Deposite Amount \n3.WithDraw Amount \n4.View Transaction \n5.LogOut");
                int choice=input.nextInt();
                switch (choice){
                    case 1:{
                        userController.viewUser(customerId);
                        break;
                    }
                    case 2:{
                        userController.deposite(customerId);
                        break;
                    }
                    case 3:{
                        userController.withDrawAmount(customerId);
                    }
                    case 4:{
                        userController.viewTransactions(customerId);
                    }
                    case 5:{
                        value=false;
                    }
                }
            }

        }
    }



}
