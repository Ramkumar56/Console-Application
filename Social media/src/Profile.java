import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Profile {

    static int id=0;
    int UserId;
    String Name;
    int Popularity;
    List<Profile> FriendsList;
    public Profile() {
        id++;
        UserId=id;
        FriendsList=new ArrayList<>();
    }
}
