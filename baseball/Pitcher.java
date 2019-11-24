package baseball;

public class Pitcher extends Player {

	double era;
	int so;
	double avg;
	double whip;
	public Pitcher(String name, String position, int runs, int hits, int homeRuns, double era, int so, double avg, double whip) {
		super(name, position, runs, hits, homeRuns);
		this.era=era;
		this.avg=avg;
		this.so=so;
		this.whip=whip;
	}
	
	public double getERA() {
		return era;
	}
	
	public int getSO() {
		return so;
	}
	
	public double getAVG() {
		return avg;
	}
	
	public double getWhip() {
		return whip;
	}
}
