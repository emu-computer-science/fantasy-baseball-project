import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Draft {

    static boolean quit = false;
    static Scanner scanner;
    static ArrayList<Player> availablePlayers;
    static ArrayList<Team> teams;
    static Team teamA;
    static Team teamB;
    static Team teamC;
    static Team teamD;

    static int draftIndex = 0;


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        availablePlayers = new ArrayList<Player>();
        teams = new ArrayList<>();
        //TEMP FOR TESTING PURPOSES
        Player playerA= new Player("Martinez, J","1B", "Detroit Tigers", 10, 50, 1, 0.0);
		Player playerB= new Player("Smith, J","C", "Detroit Tigers", 10, 50, 1, 0.0);
		Player playerC= new Player("Smith, J","C", "Detroit Tigers", 10, 50, 1, 0.0);
		Player playerD= new Player("Smith, J","C", "Detroit Tigers", 10, 50, 1, 0.0);
		Player playerE= new Player("Ray, B","P1", "Detroit Tigers", 10, 50, 1, 0.0);
		availablePlayers.add(playerA);
		availablePlayers.add(playerB);
		availablePlayers.add(playerC);
		availablePlayers.add(playerD);
		availablePlayers.add(playerE);
        teamA = new Team("A");
        teamB = new Team("B");
        teamC = new Team("C");
        teamD = new Team("D");
        teams.add(teamA);
        teams.add(teamB);
        teams.add(teamC);
        teams.add(teamD);
        shuffleDraftOrder();



        display();
    }

    public static void shuffleDraftOrder(){
        Collections.shuffle(teams);
    }



    public static void display(){
        while(!quit){
            System.out.println("Team " + teams.get(draftIndex).name + " is on the clock" );
            System.out.println("Enter a command: ");
            String parse = scanner.nextLine();
            parse = parse.toUpperCase();

            if(parse.contains("ODRAFT")){
                oDraft(teams.get(draftIndex), parse.replace("ODRAFT ",""));
            }
            if(parse.contains("IDRAFT")){
                iDraft(parse.replace("IDRAFT ",""));
            }

            if(parse.contains("TEAM")){
                printRoster(parse.replace("TEAM ",""));
            }

            if(parse.toUpperCase().contains("QUIT")){
                System.out.println("Goodbye");
                quit=true;
            }
        }

    }


    public static void printRoster(String name){
        for(int i =0; i<teams.size(); i++){
            if(name.toUpperCase().equals(teams.get(i).name.toUpperCase())){
                teams.get(i).printRoster();
            }

        }
    }

    public static int increaseDraftIndex(){
        draftIndex++;
        if(draftIndex> teams.size()-1){
            draftIndex = 0;
        }

        return draftIndex;
    }



    public static boolean oDraft(Team team, String name) {
        for (int i = 0; i < availablePlayers.size(); i++) {
            if (availablePlayers.get(i).name.toUpperCase().equals(name.toUpperCase())) {
                team.draftPlayer(availablePlayers.get(i));
                availablePlayers.remove(i);
                System.out.println(availablePlayers.get(i).name + " successfully added to Team " + team.name);
                //fix for idraft increasing draft index
                if(team == teams.get(draftIndex)){
                    increaseDraftIndex();
                }
                return true;
            }
        }
        System.out.println("Player not found");
        return false;
    }

    public static boolean iDraft(String name){
        return oDraft(teamA, name);
    }
    
    public static String overall(String position) {
		return position;
    	
    }
    
    public static String pOverall() {
		return null;
    	
    }
    
    public static String team(Team leagueMember) {
		return null;
    	
    }
    
    public static String stars(Team leagueMember) {
		return null;
    	
    }
}
