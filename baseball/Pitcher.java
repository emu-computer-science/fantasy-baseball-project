package baseball;

public class Pitcher extends Player {

    double era;
    private int so;
    private double sra;
    private double whip;

    public Pitcher(String firstName, String lastName, String team, double era, int so, double sra, double whip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
        this.era = era;
        this.so = so;
        this.sra = sra;
        this.whip = whip;
    }

    @Override
    public String toString() {
        return "P " + getName();
    }

    public double getEra() {
        return era;
    }

    public int getSo() {
        return so;
    }

    public double getSra() {
        return sra;
    }

    public double getWhip() {
        return whip;
    }
}
