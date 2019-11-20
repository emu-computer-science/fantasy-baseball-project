import java.util.ArrayList;

public class Main {

    static ArrayList<Player> players;
    static Team teamA;
    static Team teamB;
    static Team teamC;
    static Team teamD;

    public static void main(String[] args) {
        players = new ArrayList<Player>();
        teamA = new Team("A");
        teamB = new Team("B");
        teamC = new Team("C");
        teamD = new Team("D");
    }


    public static boolean oDraft(Team team, String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name.equals(name)) {
                team.draftPlayer(players.get(i));
                return true;
            }
        } return false;
    }

    public static boolean iDraft(String name){
        return oDraft(teamA, name);
    }

}
