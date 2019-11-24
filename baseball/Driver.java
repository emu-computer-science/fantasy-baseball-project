package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private static ArrayList<Hitter> getHitters() {
        ArrayList<Hitter> hitters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Hitters.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                hitters.add(new Hitter(values[1], values[0], values[2], values[3],
                        Integer.valueOf(values[4]), Integer.valueOf(values[5]), Integer.valueOf(values[6]),
                        Double.valueOf(values[7]), Double.valueOf(values[8]), Double.valueOf(values[9])));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return hitters;
    }

    private static ArrayList<Pitcher> getPitchers() {
        ArrayList<Pitcher> pitchers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Pitchers.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                pitchers.add(new Pitcher(values[1], values[0], values[2], Double.valueOf(values[3]),
                        Integer.valueOf(values[4]), Double.valueOf(values[5]), Double.valueOf(values[6])));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return pitchers;
    }

    public static void main(String[] args) {
        // Use this scanner to read the user input!
        Scanner keyboard = new Scanner(System.in);

        Draft d = new Draft(getHitters(), getPitchers());

        String response;

        do {
            // TODO: Layout all the options in this print statement
            System.out.println("Select an option:\n" +
                    "ODRAFT “playerName” leagueMember\n" +
                    "IDRAFT  “playerName”\n" +
                    "ANOTHERCOMMAND parameters\n" +
                    "ANOTHERCOMMAND parameters\n" +
                    "etc...\n" +
                    "QUIT");

            response = keyboard.nextLine();
            // Use this array to parse the keyboard input 1 word at at time!
            String[] responseArray = response.split("");

            switch (responseArray[0].toUpperCase()) {
                // TODO: make sure each command has a case!
                case "IDRAFT":
//                     Parse responseArray to get the team requested and player name
//                    d.oDraft(teamName, resposneArray[2]);
                    break;
                case "OVERALL":
//                     Parse the keyboard to grab the right info
//                     d.overall(*INSERT PARAMETERS HERE);
                    break;
                case "POVERALL":
                    // grab the things
                    // d.doTheThing();
                    break;
                case "TEAM":
                    // you get it at this point
                    // d.doTheThing();
                    break;
                case "STARS":

                    break;
                case "SAVE":

                    break;
                case "RESTORE":

                    break;
                case "EVALFUN":

                    break;
                case "PEVALFUN":

                    break;
                case "QUIT":
                    System.exit(0);
                default:
                    System.out.println("Invalid Option.");
            }
        } while (true);
    }
}
