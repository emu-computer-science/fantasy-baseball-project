package baseball;

import java.util.ArrayList;
import java.util.Collections;

public class Draft {
    ArrayList<Hitter> hitters;
    ArrayList<Pitcher> pitchers;
    ArrayList<Team> teams;
    Team teamA;
    Team teamB;
    Team teamC;
    Team teamD;
    int draftIndex;


    public Draft(ArrayList<Hitter> hitters, ArrayList<Pitcher> pitchers) {
        this.hitters = hitters;
        this.pitchers = pitchers;
        this.teams = new ArrayList<>();
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.teamC = new Team("C");
        this.teamD = new Team("D");
        this.teams.add(teamA);
        this.teams.add(teamB);
        this.teams.add(teamC);
        this.teams.add(teamD);
        teams.add(teamA); teams.add(teamB); teams.add(teamC); teams.add(teamD);
    }

    public String oDraft(String team, String name) {
    	Team selected = null;
    	for(int i=0; i<teams.size(); i++){
    		if(team.equals(teams.get(i).getName())){
    			selected = teams.get(i);
			}
		}

    	if(selected == null){
    		return "Invalid team name!";
		}

    	for (int i = 0; i < hitters.size(); i++) {
            if (hitters.get(i).getName().toUpperCase().equals(name)) {
            	if(positionFilled(selected, hitters.get(i).getPosition())) {
            		return "Position filled";
            	}
            	Hitter hitter = hitters.get(i);
                selected.draftHitter(hitters.get(i));
                hitters.remove(i);
                return hitter.toString() + " has been successfully drafted";
            }
        }

		for (int i = 0; i < pitchers.size(); i++) {
			if (pitchers.get(i).getName().toUpperCase().equals(name)) {
				if(selected.getPitchers().size()>=5) {
					return "Already have 5 pitchers!";
				}
				Pitcher pitcher = pitchers.get(i);
				selected.draftPitcher(pitchers.get(i));
				pitchers.remove(i);
				return pitcher.toString()+ " has been successfully drafted";
			}
		}


        return "Player not found";
    }

	public void printRoster(String name){
		for(int i =0; i<teams.size(); i++){
			if(name.toUpperCase().equals(teams.get(i).name.toUpperCase())){
				teams.get(i).printRoster();
				return;
			}

		}
	}

    public String iDraft(String name){
        return oDraft("A", name);
    }
    
//    public String Overall(String position) {
//    	String availablePlayers ="";
//    	for(int i=0; i<players.size(); i++) {
//    		if(players.get(i).position.equals(position))
//    			availablePlayers+=players.get(i).toString()+"\n";
//    	}
//    	return availablePlayers;
//    }
//
//    public String pOverall() {
//    	String availablePlayers ="";
//    	for(int i=0; i<players.size(); i++) {
//    		if(players.get(i).position == "P")
//    			availablePlayers+=players.get(i).toString()+"\n";
//    	}
//    	return availablePlayers;
//    }
    
//    public String team(Team leagueMember) {
//    	String teamRoster="";
//    	teamRoster+=printPosition(leagueMember, "C")+"\n";
//    	teamRoster+=printPosition(leagueMember, "1B")+"\n";
//    	teamRoster+=printPosition(leagueMember, "2B")+"\n";
//    	teamRoster+=printPosition(leagueMember, "3B")+"\n";
//    	teamRoster+=printPosition(leagueMember, "SS")+"\n";
//    	teamRoster+=printPosition(leagueMember, "LF")+"\n";
//    	teamRoster+=printPosition(leagueMember, "CF")+"\n";
//    	teamRoster+=printPosition(leagueMember, "RF")+"\n";
//    	teamRoster+=printPitchers(leagueMember);
//    	return teamRoster;
//    }

//	private String printPosition(Team leagueMember, String position) {
//		for(int i=0; i<leagueMember.roster.size(); i++) {
//    		if(leagueMember.roster.get(i).position.equals(position))
//    			return position+ " "+leagueMember.roster.get(i).getName();
//    	}
//		return position+" unfilled";
//	}
//
//	private String printPitchers(Team leagueMember) {
//		String pitchers="";
//		for(int i=0; i<leagueMember.roster.size(); i++) {
//    		if(leagueMember.roster.get(i).position.equals("P"))
//    			pitchers+="P "+ leagueMember.roster.get(i).getName()+"\n";
//    	}
//		if(pitchers.isEmpty())
//			return "No pitchers on roster";
//		return pitchers;
//	}
	
	private boolean positionFilled(Team leagueMember, String position) {
		for(int i=0; i<leagueMember.hitters.size(); i++) {
			if(leagueMember.hitters.get(i).getPosition().equals(position))
				return true;
		}
		return false;
	}
    
//	public String stars(Team leagueMember) {
//		String teamRoster="";
//		for (int i = 0; i < leagueMember.roster.size(); i++) {
//			teamRoster+=leagueMember.roster.get(i).toString();
//		}
//		return teamRoster;
//	}
}
