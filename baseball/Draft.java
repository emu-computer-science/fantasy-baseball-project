package baseball;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Draft {
    ArrayList<Hitter> hitters;
    ArrayList<Pitcher> pitchers;
    ArrayList<Team> teams;
    Team teamA;
    Team teamB;
    Team teamC;
    Team teamD;
    int draftIndex;


    public Draft() {
        this.hitters = getHitters();
        this.pitchers = getPitchers();
        this.teams = new ArrayList<>();
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.teamC = new Team("C");
        this.teamD = new Team("D");
        this.teams.add(teamA);
        this.teams.add(teamB);
        this.teams.add(teamC);
        this.teams.add(teamD);
    }

    public String oDraft(String team, String name) {

        name = name.replace("\"", "").toUpperCase();
        Team selected = null;
        for (int i = 0; i < teams.size(); i++) {
            if (team.equals(teams.get(i).getName())) {
                selected = teams.get(i);
            }
        }

        if (selected == null) {
            return "Invalid team name!";
        }

        int uniqueMatches = 0;
        Hitter uniqueHitter = null;
        Pitcher uniquePitcher = null;

        for (int i = 0; i < hitters.size(); i++) {
            if (hitters.get(i).getLastName().toUpperCase().equals(name)) {
                uniqueMatches++;
                uniqueHitter = hitters.get(i);
            }
        }
        for (int i = 0; i < pitchers.size(); i++) {
            if (pitchers.get(i).getLastName().toUpperCase().equals(name)) {
                uniqueMatches++;
                uniquePitcher = pitchers.get(i);
            }
        }

        if (uniqueMatches > 1) {
            return ("The given name was insufficient in identifying a unique player, please enter a first initial as well");
        } else if (uniqueMatches == 1) {
            if (uniqueHitter != null) {
                selected.draftHitter(uniqueHitter);
                selected.fullRoster.add(uniqueHitter);
                hitters.remove(hitters.indexOf(uniqueHitter));
                return uniqueHitter.toString() + " has been successfully drafted";
            } else {
                selected.draftPitcher(uniquePitcher);
                selected.fullRoster.add(uniquePitcher);
                hitters.remove(hitters.indexOf(uniquePitcher));
                return uniquePitcher.toString() + " has been successfully drafted";
            }

        } else {
            for (int i = 0; i < hitters.size(); i++) {
                if (hitters.get(i).getName().toUpperCase().equals(name)) {
                    if (positionFilled(selected, hitters.get(i).getPosition())) {
                        return "Position filled";
                    }
                    Hitter hitter = hitters.get(i);
                    selected.draftHitter(hitters.get(i));
                    selected.fullRoster.add(hitters.get(i));
                    hitters.remove(i);
                    return hitter.toString() + " has been successfully drafted";
                }
            }

            for (int i = 0; i < pitchers.size(); i++) {
                if (pitchers.get(i).getName().toUpperCase().equals(name)) {
                    if (selected.getPitchers().size() >= 5) {
                        return "Already have 5 pitchers!";
                    }
                    Pitcher pitcher = pitchers.get(i);
                    selected.draftPitcher(pitchers.get(i));
                    selected.fullRoster.add(pitchers.get(i));
                    pitchers.remove(i);
                    return pitcher.toString() + " has been successfully drafted";
                }
            }


            return "Player not found";
        }
    }

    public void printRoster(String name) {
        for (int i = 0; i < teams.size(); i++) {
            if (name.toUpperCase().equals(teams.get(i).name.toUpperCase())) {
                teams.get(i).printRoster();
                return;
            }

        }
    }

    public String iDraft(String name) {
        return oDraft("A", name);
    }

    public String overall(String position) {
        String availablePlayers = "";
        if (!(position.isEmpty()) && !(positionFilled(teamA, position))) {
            for (int i = 0; i < hitters.size(); i++) {
                if (hitters.get(i).getPosition().equals(position))
                    availablePlayers += hitters.get(i).toString() + " " + hitters.get(i).getValuation() + "\n";
            }
        } else if (!(position.isEmpty()) && positionFilled(teamA, position))
            availablePlayers += "Position filled already";
        else {
            for (int i = 0; i < hitters.size(); i++)
                availablePlayers += hitters.get(i).toString() + " " + hitters.get(i).getValuation() + "\n";
        }
        return availablePlayers;
    }

    public String pOverall() {
    	if (teamA.getPitchers().size() >= 5) {
            return "Already have 5 pitchers!";
        }
        String availablePlayers = "";
        for (int i = 0; i < pitchers.size(); i++) {
            availablePlayers += pitchers.get(i).toString() + "\n";
        }
        return availablePlayers;
    }

    public String team(Team leagueMember) {
        String teamRoster = "";
        teamRoster += printPosition(leagueMember, "C") + "\n";
        teamRoster += printPosition(leagueMember, "1B") + "\n";
        teamRoster += printPosition(leagueMember, "2B") + "\n";
        teamRoster += printPosition(leagueMember, "3B") + "\n";
        teamRoster += printPosition(leagueMember, "SS") + "\n";
        teamRoster += printPosition(leagueMember, "LF") + "\n";
        teamRoster += printPosition(leagueMember, "CF") + "\n";
        teamRoster += printPosition(leagueMember, "RF") + "\n";
        teamRoster += printPitchers(leagueMember);
        return teamRoster;
    }

    private String printPosition(Team leagueMember, String position) {
        for (int i = 0; i < leagueMember.hitters.size(); i++) {
            if (leagueMember.hitters.get(i).getPosition().equals(position))
                return position + " " + leagueMember.hitters.get(i).getName();
        }
        return position + " unfilled";
    }

    private String printPitchers(Team leagueMember) {
        String pitchers = "";
        for (int i = 0; i < leagueMember.pitchers.size(); i++) {
            pitchers += "P " + leagueMember.pitchers.get(i).getName() + "\n";
        }
        if (pitchers.isEmpty())
            return "No pitchers on roster";
        return pitchers;
    }

    private boolean positionFilled(Team leagueMember, String position) {
        for (int i = 0; i < leagueMember.hitters.size(); i++) {
            if (leagueMember.hitters.get(i).getPosition().equals(position))
                return true;
        }
        return false;
    }

    public String stars(String name) {
        String teamRoster = "";
        Team selected = null;
        for (int i = 0; i < teams.size(); i++) {
            if (name.toUpperCase().equals(teams.get(i).name.toUpperCase())) {
                selected = teams.get(i);
            }
        }
        if (!(selected == null)) {
            for (int i = 0; i < selected.fullRoster.size(); i++) {
                teamRoster += selected.fullRoster.get(i).toString() + " \n";
            }
        }
        return teamRoster;
    }


    public boolean save(String fileName) {
        BufferedWriter writer = null;
        try {
            for (int i = 0; i < teams.size(); i++) {
                Team currentTeam = teams.get(i);
                writer = new BufferedWriter(new FileWriter(fileName + " " + currentTeam.getName() + ".fantasy.txt"));
                for (int j = 0; j < currentTeam.fullRoster.size(); j++) {
                    writer.write(currentTeam.fullRoster.get(j).getName() + "\n");
                }

                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean restore(String fileName) {
        // Restarting every team to start from the restore point
        this.teams = new ArrayList<>();
        this.teamA = new Team("A");
        this.teamB = new Team("B");
        this.teamC = new Team("C");
        this.teamD = new Team("D");
        this.teams.add(teamA);
        this.teams.add(teamB);
        this.teams.add(teamC);
        this.teams.add(teamD);
        this.hitters = getHitters();
        this.pitchers = getPitchers();

        try {
            for (int i = 0; i < teams.size(); i++) {
                String player;
                Team currentTeam = teams.get(i);
                BufferedReader reader = new BufferedReader(new FileReader(fileName + " " + currentTeam.getName() + ".fantasy.txt"));
                while ((player = reader.readLine()) != null) {
                    System.out.println(oDraft(currentTeam.getName(), "\"" + player + "\""));
                }

                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void evalFun(String expression) throws ScriptException {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            for (int i = 0; i < hitters.size(); i++) {
                engine.put("AVG", hitters.get(i).getAvg());
                engine.put("OBP", hitters.get(i).getAvg());
                engine.put("OPS", hitters.get(i).getOps());
                engine.put("RUNS", hitters.get(i).getRuns());
                engine.put("HITS", hitters.get(i).getHits());
                engine.put("HOMERUNS", hitters.get(i).getHomeRuns());
                hitters.get(i).setValuation((double) engine.eval(expression));
            }
            Collections.sort(hitters,
                    (o1, o2) -> o2.getValuation().compareTo(o1.getValuation()));
        } catch (Exception e) {
            System.out.println("Please only use approved variables, AVG, OBP, OPS"
                    + "RUNS, HITS, HOMERUNS");
        }
    }

    public void pEvalFun(String expression) throws ScriptException {
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            for (int i = 0; i < pitchers.size(); i++) {
                engine.put("ERA", pitchers.get(i).getEra());
                engine.put("WHIP", pitchers.get(i).getWhip());
                engine.put("SO", pitchers.get(i).getSo());
                engine.put("SRA", pitchers.get(i).getSra());
                pitchers.get(i).setValuation((double) engine.eval(expression));
            }
            Collections.sort(pitchers,
                    (o1, o2) -> o2.getValuation().compareTo(o1.getValuation()));
        } catch (Exception e) {
            System.out.println("Please only use approved variables, ERA, WHIP, "
                    + "SRA");
        }
    }

    ArrayList<Hitter> getHitters() {
        ArrayList<Hitter> hitters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Hitters.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                hitters.add(new Hitter(values[1], values[0], values[3], values[2],
                        Integer.valueOf(values[4]), Integer.valueOf(values[5]), Integer.valueOf(values[6]),
                        Double.valueOf(values[7]), Double.valueOf(values[8]), Double.valueOf(values[9])));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return hitters;
    }

    ArrayList<Pitcher> getPitchers() {
        ArrayList<Pitcher> pitchers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Pitchers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                pitchers.add(new Pitcher(values[1], values[0], values[2], Double.valueOf(values[3]),
                        Integer.valueOf(values[4]), Double.valueOf(values[5]), Double.valueOf(values[6])));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return pitchers;
    }
}
