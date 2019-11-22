package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    private static ArrayList<Player> addPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("players.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                players.add(new Player(values[1] + " " + values[0], values[2], Integer.valueOf(values[3]), Integer.valueOf(values[4]), Integer.valueOf(values[5])));
            }
        } catch (IOException e) {
            System.out.println("Cannot read file!");
        }

        return players;
    }

    public static void main(String[] args) {
        // Use this scanner to read the user input!
        Scanner keyboard = new Scanner(System.in);

        Draft d = new Draft(addPlayers());

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
                    // Parse responseArray to get the team requested and player name
//                    d.oDraft(teamName, resposneArray[2]);
                    break;
                case "OVERALL":
                    // Parse the keyboard to grab the right info
                    // d.overall(*INSERT PARAMETERS HERE);
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
                case "PEVALFUN ":

                    break;
                default:
                    System.out.println("Invalid Option.");
            }
        } while (!response.equals("QUIT"));
    }
}
