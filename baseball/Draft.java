package baseball;

import java.util.ArrayList;

public class Draft {
    ArrayList<Player> players;
    Team teamA;
    Team teamB;
    Team teamC;
    Team teamD;

    public Draft(ArrayList<Player> players) {
        this.players = players;
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.teamC = new Team("C");
        this.teamD = new Team("D");
    }

    public boolean oDraft(Team team, String name) {
    	for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name.equals(name)) {
            	if(positionFilled(team, players.get(i).getPosition())) {
            		System.out.println("Position filled!");
            		return false;
            	}
                team.draftPlayer(players.get(i));
                players.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean iDraft(String name){
        return oDraft(teamA, name);
    }
    
    public String Overall(String position) {
    	String availablePlayers ="";
    	for(int i=0; i<players.size(); i++) {
    		if(players.get(i).position.equals(position))
    			availablePlayers+=players.get(i).toString()+"\n";
    	}
    	return availablePlayers;
    }
    
    public String pOverall() {
    	String availablePlayers ="";
    	for(int i=0; i<players.size(); i++) {
    		if(players.get(i).position == "P")
    			availablePlayers+=players.get(i).toString()+"\n";
    	}
    	return availablePlayers;
    }
    
    public void team(Team leagueMember) {
    	System.out.println(printPosition(leagueMember, "C"));
    	System.out.println(printPosition(leagueMember, "1B"));
    	System.out.println(printPosition(leagueMember, "2B"));
    	System.out.println(printPosition(leagueMember, "3B"));
    	System.out.println(printPosition(leagueMember, "SS"));
    	System.out.println(printPosition(leagueMember, "LF"));
    	System.out.println(printPosition(leagueMember, "CF"));
    	System.out.println(printPosition(leagueMember, "RF"));
    	System.out.println(printPitchers(leagueMember));
    }

	private String printPosition(Team leagueMember, String position) {
		for(int i=0; i<leagueMember.roster.size(); i++) {
    		if(leagueMember.roster.get(i).position.equals(position))
    			return position+ " "+leagueMember.roster.get(i).getName();
    	}
		return position+" unfilled";
	}
	
	private String printPitchers(Team leagueMember) {
		String pitchers="";
		for(int i=0; i<leagueMember.roster.size(); i++) {
    		if(leagueMember.roster.get(i).position.equals("P"))
    			pitchers+="P "+ leagueMember.roster.get(i).getName()+"\n";
    	}
		if(pitchers.isEmpty())
			return "No pitchers on roster";
		return pitchers;
	}
	
	private boolean positionFilled(Team leagueMember, String position) {
		for(int i=0; i<leagueMember.roster.size(); i++) {
			if(leagueMember.roster.get(i).position.equals(position));
				return true;
		}
		return false;
	}
    
	public void stars(Team leagueMember) {
		for (int i = 0; i < leagueMember.roster.size(); i++) {
			System.out.println(leagueMember.roster.get(i).position
					+ " " + leagueMember.roster.get(i).name);
		}
	}
}
