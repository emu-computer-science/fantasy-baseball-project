package baseball;

public class Player {

    String name;
    String position;
    String realTeam;
    int runs;
    int hits;
    int homeRuns;
    double valuation;

    public Player(String name, String position, int runs, int hits, int homeRuns) {
        this.name = name;
        this.position = position;
        this.runs = runs;
        this.hits = hits;
        this.homeRuns = homeRuns;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
    
    public String getRealTeam() {
    	return realTeam;
    }

    public int getRuns() {
        return runs;
    }

    public int getHits() {
        return hits;
    }

    public int getHomeRuns() {
        return homeRuns;
    }
    
    public String toString() {
    	return name+" "+ position;
    }
}
