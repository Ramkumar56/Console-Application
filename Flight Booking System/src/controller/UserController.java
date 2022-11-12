package controller;

import model.Database;
import model.UserDetails;
import view.UserView;

public class UserController {

    public void addUserDetails(String name, long phoneNumber, String email, String password) {
        UserDetails userDetails=new UserDetails(name, phoneNumber, password, email);
        int userId=userDetails.getUserId();
        Database database=new Database();
        database.addUserDetails(userId,userDetails);
        UserView userView=new UserView();
        userView.displayUserDetails(database.userDetails.get(userId));
    }

    public Boolean isValidUser(int userId, String passwordCheck) {
        Database database=new Database();
        if(database.userDetails.containsKey(userId)){
            if(database.userDetails.get(userId).getPassword().equals(passwordCheck))
                return true;

        }
        return false;
    }
}
