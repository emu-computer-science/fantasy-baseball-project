public class Player {

    String name;
    String position;
    String realTeam;
    int runs;
    int hits;
    int homeRuns;
    double valuation;

    public Player(String name, String position, String realTeam, int runs, int hits, int homeRuns, double valuation) {
        this.name = name;
        this.position = position;
        this.realTeam = realTeam;
        this.runs = runs;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.valuation = valuation;
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
    
    public double getValuation() {
    	return valuation;
    }
    
    public String toString() {
    	return name+" "+realTeam+" "+position+" "+valuation;
    }
}
