import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
public class Main {
    public static Profile CreateAccount(String Name,int popularity){
        Profile create = new Profile();
        create.Name=Name;
        create.Popularity=popularity;
        return create;
    }

    public static void  AddFriend(Profile User,Profile Friend){
        if(User.FriendsList.contains(Friend)){
            System.out.println("\n\t You are Already Friends!");
            return;
        }
        User.FriendsList.add(Friend);
        Friend.FriendsList.add(User);
    }

    public static void ViewMutualFriends(List<Profile> UserId1,List<Profile> UserId2){
        System.out.println("\n\t Your Mutual");
        int Flag=0;
        for(Profile temp:UserId1) {
            if (UserId2.contains(temp)) {
                System.out.println("    " + temp.Name);
                Flag = 1;
            }
        }
            if(Flag==0){
                System.out.println("\n\t None.....");
            }
    }
    public static void ViewData(Profile user){
        System.out.println("\n\t UserId : "+user.UserId);
        System.out.println("\n\t Name : "+user.Name);
        System.out.println("\n\t Popularity : "+user.Popularity);
        System.out.println("\n\t Your Friends List :");
        int Flag=0;
        for(Profile temp: user.FriendsList){
            Flag=1;
            System.out.println("   "+temp.Name);
        }
        if(Flag==0){
            System.out.println("\t\tYou have no Friends till now ");
        }
    }
    public static void DeleteAccount(Profile org,List<Profile> user){
        for(Profile temp:user){
            if(temp.FriendsList.contains(org)){
                ViewData(org);
                temp.FriendsList.remove(org);
            }
        }
    }
    public static void SearchUser(String Name){

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Profile> map=new HashMap();
        List<Profile> popular=new ArrayList<>();
        int id =1;

        boolean c= true;
        while(c) {
            System.out.println("\n\n\t***SOCIAL NETWORK***\n\n");
            System.out.print("\t1.Create new profile\n\t2.Add friends\n\t3.View Mutual friends\n\t4.View specific data\n\t5.Delete an account\n\t6.Most popular person at the moment\n\n\tEnter your choice : ");
            int ch=in.nextInt();
            Collections.sort(popular,(a,b)->b.Popularity-a.Popularity);
            switch (ch) {
                case 1: {
                    System.out.println("Enter your Name ");
                    String Name = in.next();
                    System.out.println("Enter your popularity ");
                    int popularity = in.nextInt();
                    map.put(id,CreateAccount(Name,popularity));
                    popular.add(map.get(id));
                    System.out.println("\n\tSuccessfully created your Account\n\tYour ID is : "+id);
                    id++;
                    break;
                }
                case 2: {
                    System.out.println("Enter the user Id");
                    int UserId=in.nextInt();
                    if(map.containsKey(UserId)){
                        System.out.println("Enter  your friend Id");
                        int FriendId =in.nextInt();
                        if(map.containsKey(FriendId)){
                            AddFriend(map.get(UserId),map.get(FriendId));
                            System.out.println("\n\t your Friend list updated!.....");
                        }
                        else {
                            System.out.println("\n\t your Friend UserID Not Found!.....");
                        }
                    }
                    else {
                        System.out.println("\n\t  User Not Found!.....");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Enter the First UserId ");
                    int UserId1=in.nextInt();
                    if(map.containsKey(UserId1)){
                        System.out.println("Enter the Second UserId ");
                        int UserId2= in.nextInt();
                        if(map.containsKey(UserId2)){
                            ViewMutualFriends(map.get(UserId1).FriendsList,map.get(UserId2).FriendsList);
                        }
                        else {
                            System.out.println("The Second UserId Not Found!.....");
                        }
                    }
                    break;

                }
                case 4:{
                    System.out.println("Enter your UserId ");
                    int User=in.nextInt();
                    if(map.containsKey(User)){
                        ViewData(map.get(User));
                    }
                    else {
                        System.out.println("UserId Not Found!.....");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Enter your UserID to Delete your Account ");
                    int User=in.nextInt();
                    if(map.containsKey(User)){
                        DeleteAccount(map.get(User),map.get(User).FriendsList);
                        popular.remove(User);
                        map.remove(User);
                        System.out.println("\n\t Your Account Successfully Deleted");
                    }
                    break;
                }
                case 6: {
                    if (popular.size() != 0) {
                        System.out.println("\n\tMost popular person is : " + popular.get(0).Name);
                    } else {
                        System.out.println("\n\t No accounts found ....!");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Enter Your UserId ");
                    String UserId=in.next();
                    if(map.containsKey(UserId)){
                        System.out.println("Enter the Name for Search");
                        String Name=in.next();
                        SearchUser(Name);
                    }
                    else {
                        System.out.println("UserId not Found!.....");

                    }
                }
                case 8: {
                    c=false;
                    System.out.println("Successfully exited");
                }
            }

        }
    }
}
