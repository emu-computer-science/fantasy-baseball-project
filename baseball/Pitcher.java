package baseball;

public class Pitcher extends Player {

    double era;
    private int so;
    private double avg;
    private double whip;
    private double ip;

    public Pitcher(String firstName, String lastName, String team, double era, 
    		double ip, int so, double avg, double whip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.era = era;
        this.ip = ip;
        this.so = so;
        this.avg = avg;
        this.whip = whip;
        this.setValuation(getIp());
    }

    @Override
    public String toString() {
        return "P " + getName();
    }

    public double getEra() {
        return era;
    }
    
    public double getIp() {
    	return ip;
    }

    public int getSo() {
        return so;
    }

    public double getAvg() {
        return avg;
    }

    public double getWhip() {
        return whip;
    }
}
