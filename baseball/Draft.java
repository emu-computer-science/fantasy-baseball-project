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

    public String oDraft(Team team, String name) {
    	for (int i = 0; i < players.size(); i++) {
            if (players.get(i).name.equals(name)) {
            	if(positionFilled(team, players.get(i).getPosition())) {
            		return "Position filled";
            	}
                team.draftPlayer(players.get(i));
                String player=players.get(i).toString();
                players.remove(i);
                return player +" has been drafted";
            }
        }
        return "Player not found";
    }

    public String iDraft(String name){
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
    
    public String team(Team leagueMember) {
    	String teamRoster="";
    	teamRoster+=printPosition(leagueMember, "C")+"\n";
    	teamRoster+=printPosition(leagueMember, "1B")+"\n";
    	teamRoster+=printPosition(leagueMember, "2B")+"\n";
    	teamRoster+=printPosition(leagueMember, "3B")+"\n";
    	teamRoster+=printPosition(leagueMember, "SS")+"\n";
    	teamRoster+=printPosition(leagueMember, "LF")+"\n";
    	teamRoster+=printPosition(leagueMember, "CF")+"\n";
    	teamRoster+=printPosition(leagueMember, "RF")+"\n";
    	teamRoster+=printPitchers(leagueMember);
    	return teamRoster;
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
			if(leagueMember.roster.get(i).position.equals(position))
				return true;
		}
		return false;
	}
    
	public String stars(Team leagueMember) {
		String teamRoster="";
		for (int i = 0; i < leagueMember.roster.size(); i++) {
			teamRoster+=leagueMember.roster.get(i).toString();
		}
		return teamRoster;
	}
}
