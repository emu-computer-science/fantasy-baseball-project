package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptException;

public class Driver {

    private static ArrayList<Hitter> getHitters() {
        ArrayList<Hitter> hitters = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Hitters.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                hitters.add(new Hitter(values[1], values[0], values[3], values[2],
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
        try (BufferedReader br = new BufferedReader(new FileReader("src/Pitchers.csv"))) {
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

    public static void main(String[] args) throws ScriptException {
        // Use this scanner to read the user input!
        Scanner keyboard = new Scanner(System.in);

        Draft d = new Draft(getHitters(), getPitchers());

        String response;

        do {
            // TODO: Layout all the options in this print statement
            System.out.println("Select an option:\n" +
                    "ODRAFT lastName,firstInitial leagueMember\n" +
                    "IDRAFT  lastName,firstInitial\n" +
                    "TEAM teamName \n" +
                    "ANOTHERCOMMAND parameters\n" +
                    "etc...\n" +
                    "QUIT");

            response = keyboard.nextLine();
            // Use this array to parse the keyboard input 1 word at at time!
            String[] responseArray = response.split(" ");


            switch (responseArray[0].toUpperCase()) {
                // TODO: make sure each command has a case!
                case "ODRAFT":
                    if (responseArray.length > 1) {
                        System.out.println(d.oDraft(responseArray[2].toUpperCase(), responseArray[1].toUpperCase()));
                    }

                    break;
                case "IDRAFT":
                    if (responseArray.length > 1) {
                        System.out.println(d.iDraft(responseArray[1].toUpperCase()));
                    }
                    break;
                case "OVERALL":
                    if (responseArray.length == 2) {
                        System.out.println(d.overall(responseArray[1].toUpperCase()));
                    }
                    if (responseArray.length == 1) {
                        System.out.println(d.overall(""));
                    }
                    break;
                case "POVERALL":
                    System.out.println(d.pOverall());
                    break;
                case "TEAM":
                    if (responseArray.length > 1) {
                        d.printRoster(responseArray[1].toUpperCase());
                    }
                    break;
                case "STARS":
                    System.out.println(d.stars(responseArray[1].toUpperCase()));
                    break;
                case "SAVE":
                    d.save(responseArray[1]);
                    break;
                case "RESTORE":

                    break;
                case "EVALFUN":
                    d.evalFun(responseArray[1]);
                    break;
                case "PEVALFUN":
                    d.pEvalFun(responseArray[1]);
                    break;
                case "QUIT":
                    System.exit(0);
                default:
                    System.out.println("Invalid Option.");
            }
        } while (true);
    }
}
