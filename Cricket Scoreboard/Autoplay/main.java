import java.util.*;
class Player {
    String name;
    String type;
}
class Team {
    static int i=0;
    String name;
    int teamNo;
    List<Player>players;
    public Team() {
        players=new ArrayList<>();
        i++;
        teamNo=i;
    }
}
class Toss{

}

class batting {

    public static int FirstInnings(String batsman[], String bowlers[]) {
        Random r = new Random();
        String Batsman[] = new String[11];
        String Bowler[] = new String[11];
        for (int i = 0; i < 11; i++) {
            Batsman[i] = batsman[i];
        }
        for (int i = 0; i < 11; i++) {
            Bowler[i] = bowlers[i];
        }
        int BatsmanScore[] = new int[11];
        int BowlerWicket = 0;
        int BowlerScore = 0;
        int TotalScore = 0, Extras = 0, a = 0, Balls = 1;
        int j = 1, k = 1, e = 5, wk = 1;
        a:
        for (int i = 0; i < 11; ) {
            b:
            for (; j < 11; ) {
                for (; k < 6; k++) {
                    System.out.println("The " + k + " Over is Bowled by " + Bowler[e]);
                    if (Balls <= 6) {
                        int Run = r.nextInt(-2, 7);
                        Run=Run*2;
                        if (((Run == 1) || (Run == 3) || (Run % 2 == 0)) && (Run != 5) && (Run >= 0) && (a == 0) && ((k == 0) || (k == 2) || (k == 4))) {
                            BatsmanScore[i] += Run;
                            BowlerScore += Run;
                            Balls = Balls + 1;
                            if ((Run == 1) || (Run == 3)) {
                                a++;
                            }
                        } else if (((Run == 1) || (Run == 3) || (Run % 2 == 0)) && (Run != 5) && (Run >= 0) && (a == 1) && ((k == 1) || (k == 3) || (k == 5))) {
                            BatsmanScore[j] += Run;
                            BowlerScore += Run;
                            Balls = Balls + 1;
                            if ((Run == 1) || (Run == 3)) {
                                a--;
                            }
                        } else if ((Run == -1) || (Run == 5)) {
                            Extras += 1;
                        } else if (Run == -2) {
                            BowlerWicket = wk;
                            int b = r.nextInt(2);
                            if (b == 0) {
                                System.out.println(Batsman[i] + " is OUT in " + BatsmanScore[i]);
                                i = i + 2;
                                Balls = Balls + 1;
                                continue a;
                            } else {
                                System.out.println(Batsman[j] + " is OUT in " + BatsmanScore[j]);
                                j = j + 2;
                                Balls = Balls + 1;
                                continue b;
                            }
                        } else {
                            Extras += 1;
                        }
                    }e++;
                    TotalScore += BatsmanScore[i] + BatsmanScore[j] + Extras;
                    System.out.println(Batsman[i] + " is " + BatsmanScore[i] + " in " + k + " Overs ");
                    System.out.println(Batsman[j] + " is " + BatsmanScore[j] + " in " + k + " Overs ");
                    System.out.println("Extras in " + k + " Overs is " + Extras + " runs");
                    System.out.println("The Bowler " + Bowler[e] + "Gives " + TotalScore + " runs in " + k + " Overs");
                    Balls = 1;
                }
                System.out.println("Total " + TotalScore);
                break a;
            }
        }
        return TotalScore;
    }

    public static int SecondInnings(String batsman[], String bowlers[]) {
        Random r = new Random();
        String Batsman[] = new String[11];
        String Bowler[] = new String[11];
        for (int i = 0; i < 11; i++) {
            Batsman[i] = batsman[i];
        }
        for (int i = 0; i < 11; i++) {
            Bowler[i] = bowlers[i];
        }
        int BatsmanScore[] = new int[11];
        int BowlerWicket = 0;
        int BowlerScore = 0;
        int TotalScore = 0, Extras = 0, a = 0, Balls = 1;
        int j = 1, k = 1,e=5, wk = 1;
        a:
        for (int i = 0; i < 11; ) {
            b:
            for (; j < 11; ) {
                for (; k < 6; k++) {
                    System.out.println("The " + k + " Over is Bowled by " + Bowler[e]);
                    if (Balls <= 6) {
                        int Run = r.nextInt(-2, 7);
                        Run=Run*2;
                        if (((Run == 1) || (Run == 3) || (Run % 2 == 0)) && (Run != 5) && (Run >= 0) && (a == 0) && ((k == 0) || (k == 2) || (k == 4))) {
                            BatsmanScore[i] += Run;
                            BowlerScore += Run;
                            Balls = Balls + 1;
                            if ((Run == 1) || (Run == 3)) {
                                a++;
                            }
                        } else if (((Run == 1) || (Run == 3) || (Run % 2 == 0)) && (Run != 5) && (Run >= 0) && (a == 1) && ((k == 1) || (k == 3) || (k == 5))) {
                            BatsmanScore[j] += Run;
                            BowlerScore += Run;
                            Balls = Balls + 1;
                            if ((Run == 1) || (Run == 3)) {
                                a--;
                            }
                        } else if ((Run == -1) || (Run == 5)) {
                            Extras += 1;
                        } else if (Run == -2) {
                            BowlerWicket = wk;
                            int b = r.nextInt(2);
                            if (b == 0) {
                                System.out.println(Batsman[i] + " is OUT in " + BatsmanScore[i]);
                                i = i + 2;
                                Balls = Balls + 1;
                                continue a;
                            } else {
                                System.out.println(Batsman[j] + " is OUT in " + BatsmanScore[j]);
                                j = j + 2;
                                Balls = Balls + 1;
                                continue b;
                            }
                        } else {
                            Extras += 1;
                        }
                    } e++;
                    TotalScore += BatsmanScore[i] + BatsmanScore[j] + Extras;
                    System.out.println(Batsman[i] + " is " + BatsmanScore[i] + " in " + k + " Overs ");
                    System.out.println(Batsman[j] + " is " + BatsmanScore[j] + " in " + k + " Overs ");
                    System.out.println("Extras in " + k + " Overs is " + Extras + " runs");
                    System.out.println("The Bowler " + Bowler[e] + "  Gives " + TotalScore + " runs in " + k + " Overs");
                    Balls = 1;
                    System.out.println();
                }
                System.out.println();
                System.out.println("Total " + TotalScore);
                break a;
            }
        }
        return TotalScore;
    }
}
public class main {
    public static void showTeam(Team temp) {
        System.out.println("Team Name:"+temp.name);
        System.out.println("Team Number:"+temp.teamNo);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] teamName={"India","pakistan","Australia"};
        System.out.println("******** Select Teams ********");
        for(int i=0,j=1;i<teamName.length;i++) {
            System.out.println("       "+j+++"."+teamName[i]);
        }
        Map<Integer,Team> teams=new HashMap<>();
        for(int i=0;i<8;i++)
        {
            Team t=new Team();
            teams.put(i+1,t);
        }
        String team1[][]={{"Rohit","Batsman"},{"Virat","Batsman"},{"Surya","Batsman"},{"Dhoni","Wicket-keeper"},{"pant","Batsman"},{"jadu","Allrounder"},{"hardik","Allrounder"},{"Dk","Batsman"},{"Ashwin","Spin"},{"bumrah","Blower",},{"bhuvi","Blower"}};
        String team2[][]={{"Rizwan","Batsman"},{"Azam","Batsman"},{"Zaman","Batsman"},{"Ahmed","Wicket-keeper"},{"Shall","Batsman"},{"Nawaz","Allrounder"},{"Ali","Allrounder"},{"H.Ali","Batsman"},{"Qadir","Spin"},{"Rauf","Blower",},{"Hasnain","Blower"}};
        String team3[][]={{"Finch","Batsman"},{"Smith","Batsman"},{"David","Batsman"},{"Agar","Wicket-keeper"},{"Green","Batsman"},{"Maxwell","Allrounder"},{"Stonis","Allrounder"},{"Marsh","Batsman"},{"Zampa","Spin"},{"Hazlewood","Blower",},{"Starc","Blower"}};


        //list for adding the team players
        List<String[][]> lst =new ArrayList<>();
        lst.add(team1);
        lst.add(team2);
        lst.add(team3);
        Team temp;
        //adding the team name and player name in theier classes
        for(int i=0;i<teamName.length;i++){
            temp=teams.get(i+1);
            temp.name=teamName[i];
            String t[][]=lst.get(i);
            for(int j=0;j<11;j++) {
                Player p=new Player();
                p.name=t[j][0];
                p.type=t[j][1];
                temp.players.add(p);
            }
        }


        System.out.print("Enter the first team id");
        int t1=in.nextInt();
        System.out.println("Enter the second team id");
        int t2=in.nextInt();

        //to get team1 details
        Team tea1=teams.get(t1);
        showTeam(tea1);



        //to get team2 details
        Team tea2;
        tea2=teams.get(t2);
        showTeam(tea2);

        System.out.println(" Today is wonderfull day "+" The match between  "+tea1.name+"  Vs "+tea2.name);
        System.out.println("lets ready to spin the toss");
        System.out.println();
        //Toss
        Toss to= new Toss();
        Random r = new Random();
        int tos=r.nextInt(2);

        String bats[][]=lst.get(t1-1);
        String[] batsman= new String[11];
        for (int i=0;i<11;i++)
            batsman[i]=bats[i][0];

        System.out.println(tea1.name+" Squad ");
        for (int i=0;i<11;i++)
            System.out.println(batsman[1]);


        String[] bowlers = new String[11];
        String bowl[][]=lst.get(t2-1);
        for(int i=0;i<11;i++)
            bowlers[i]=bowl[i][0];

        System.out.println(tea2.name+" Squad");
        for(int i=0;i<11;i++)
            System.out.println(bowlers[i]);

        batting bat=new batting();

        int total1=0;
        int total2=0;
        if(tos==0) {

            System.out.println("It's head  "+tea1.name+"  won the toss and elected to bat first");

            //sending the team to bat class
            total1 = bat. FirstInnings(batsman,bowlers);
            System.out.println();
            System.out.println(tea1.name+" Total Score "+total1);
            System.out.println(tea2.name+" take "+(total1+1)+" to win the Match");
            System.out.println();
            total2= bat. SecondInnings(bowlers,batsman);
        }
        else {

            System.out.println("It's  "+tea2.name+"  won the toss and elected to bat first");

            //Sending the team to bat class
            total1=bat. FirstInnings(bowlers,batsman);
            System.out.println();
            System.out.println(tea2.name+" Total Score "+total1);
            System.out.println(tea1.name+" take "+(total1+1)+" to win the Match");
            System.out.println();
            total2=bat. SecondInnings(batsman,batsman);
        }
        if(total1>total2){
            System.out.println();
            System.out.println(tea1.name+"defeat"+tea2.name);
        }
        else {
            System.out.println();
            System.out.println(tea2.name+"  defeat  "+tea1.name);
        }
    }


}
