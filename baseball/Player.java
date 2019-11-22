package baseball;

public class Player {

    String name;
    String position;
    int runs;
    int hits;
    int homeRuns;

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

    public int getRuns() {
        return runs;
    }

    public int getHits() {
        return hits;
    }

    public int getHomeRuns() {
        return homeRuns;
    }
}
