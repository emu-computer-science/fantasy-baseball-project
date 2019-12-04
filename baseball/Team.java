package baseball;

import java.util.ArrayList;

public class Team {
    String name;
    ArrayList<Hitter> hitters;
    ArrayList<Pitcher> pitchers;
    ArrayList<Player> fullRoster;
    String [] positionOrder;
    double teamValuation;


    public Team(String name) {
        this.name = name;
        this.positionOrder = new String[] {"C", "1B", "2B", "3B", "SS", "LF", "CF", "RF"};
        this.hitters = new ArrayList<>();
        this.pitchers = new ArrayList<>();
        this.fullRoster = new ArrayList<>();

    }

    public String getName(){
        return name;
    }

    public ArrayList<Pitcher> getPitchers(){
        return pitchers;
    }

    public void draftPitcher(Pitcher player){
        pitchers.add(player);
    }
    public void draftHitter(Hitter player){
        hitters.add(player);
    }


    public void printRoster(){

        for(int i=0; i<positionOrder.length; i++){
            for(int j=0; j<hitters.size(); j++){
                if(positionOrder[i].equals(hitters.get(j).getPosition())){
                    System.out.println(hitters.get(j).toString());
                }
            }
        }

        for(int i=0; i<pitchers.size(); i++){
            System.out.println(pitchers.get(i).toString());
        }
    }
}
