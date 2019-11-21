import java.util.ArrayList;

public class Main {

    static ArrayList<Player> availablePlayers;
    static Team teamA;
    static Team teamB;
    static Team teamC;
    static Team teamD;

    public static void main(String[] args) {
        availablePlayers = new ArrayList<Player>();
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
    }


    public static boolean oDraft(Team team, String name) {
        for (int i = 0; i < availablePlayers.size(); i++) {
            if (availablePlayers.get(i).name.equals(name)) {
                team.draftPlayer(availablePlayers.get(i));
                return true;
            }
        } return false;
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
