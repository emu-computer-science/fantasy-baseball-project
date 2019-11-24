package baseball;

public class Player {

    String firstName;
    String lastName;
    String team;
    private double valuation;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public double getValuation() {
        return valuation;
    }

}
