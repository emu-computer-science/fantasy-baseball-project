import java.util.ArrayList;

public class Team {
    String name;
    ArrayList<Player> roster;


    public Team(String name) {
        this.name = name;
        roster = new ArrayList<>();
    }

    public void draftPlayer(Player player){
        roster.add(player);
    }
}
