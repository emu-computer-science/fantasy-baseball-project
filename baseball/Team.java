package baseball;

import java.util.ArrayList;

public class Team {
    String name;
    ArrayList<Player> roster;
    double teamValuation;


    public Team(String name) {
        this.name = name;
        roster = new ArrayList<>();
    }

    public void draftPlayer(Player player){
        roster.add(player);
    }

    public void printRoster(){
        for(int i=0; i<roster.size(); i++){
            System.out.println(roster.get(i).position + " " + roster.get(i).name);
        }
    }
}
