package baseball;

public class Hitter extends Player {
	double avg;
	double obp;
	double slg;
	double ops;
	public Hitter(String name, String position, int runs, int hits, int homeRuns, double avg, double obp, double slg, double ops) {
		super(name, position, runs, hits, homeRuns);
		this.avg=avg;
		this.obp=obp;
		this.slg=slg;
		this.ops=ops;
	}
	
	public double getAVG() {
		return avg;
	}
	
	public double getOBP() {
		return obp;
	}
	
	public double getSLG() {
		return slg;
	}
	
	public double ops() {
		return ops;
	}
}
