package baseball;

public class Hitter extends Player {

    private double avg;
    private double obp;
    private double ops;
    private int runs;
    private int hits;
    private int homeRuns;
    private String position;

    Hitter(String firstName, String lastName, String position, String team, 
    		int runs, int hits, int homeRuns, double avg, double obp, double ops) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.team = team;
        this.runs = runs;
        this.hits = hits;
        this.homeRuns = homeRuns;
        this.avg = avg;
        this.obp = obp;
        this.ops = ops;
        this.setValuation(getAvg());
    }

    @Override
    public String toString() {
        return  getPosition() + " " + getName();
    }

    public String getPosition() {
        return position;
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

    public double getAvg() {
        return avg;
    }

    public double getObp() {
        return obp;
    }

    public double getOps() {
        return ops;
    }
}
