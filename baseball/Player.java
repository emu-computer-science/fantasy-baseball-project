package baseball;

public class Player {

    String firstName;
    String lastName;
    String team;
    private Double valuation;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName(){return lastName.trim() + ", " + firstName.trim();}


    public String getTeam() {
        return team;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public Double getValuation() {
        return valuation;
    }

}
