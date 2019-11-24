package baseball;

import java.util.ArrayList;

public class Draft {
    ArrayList<Hitter> hitters;
    ArrayList<Pitcher> pitchers;
    Team teamA;
    Team teamB;
    Team teamC;
    Team teamD;

    public Draft(ArrayList<Hitter> hitters, ArrayList<Pitcher> pitchers) {
        this.hitters = hitters;
        this.pitchers = pitchers;
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.teamC = new Team("C");
        this.teamD = new Team("D");
    }

//    public boolean oDraft(Team team, String name) {
//        for (int i = 0; i < players.size(); i++) {
//            if (players.get(i).name.equals(name)) {
//                team.draftPlayer(players.get(i));
//                return true;
//            }
//        } return false;
//    }

//    public boolean iDraft(String name){
//        return oDraft(teamA, name);
//    }
}
