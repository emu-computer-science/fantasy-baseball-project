package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Player> addPlayers() {
        try (BufferedReader br = new BufferedReader(new FileReader("players.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                players.add(new Player(values[1].strip() + " " + values[0], values[2], Integer.valueOf(values[3]), Integer.valueOf(values[4]), Integer.valueOf(values[5])));
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
                    "ODRAFT playerName leagueMember\n" +
                    "IDRAFT playerName \n" +
                    "OVERALL position\n" +
                    "POVERALL \n" +
                    "TEAM leagueMember\n" +
                    "STARS leagueMember\n" +
                    "SAVE filename \n" +
                    "Restore filename\n" +
                    "QUIT");
            response = keyboard.nextLine();
            // Use this array to parse the keyboard input 1 word at at time!
            String[] responseArray = response.split(" ");
            switch (responseArray[0].toUpperCase()) {
                // TODO: make sure each command has a case!
            
                case "IDRAFT":
                    System.out.println(d.iDraft(responseArray[1]+" "+responseArray[2]));
                    break;
                case "OVERALL":
                    System.out.println(d.Overall(responseArray[1]));
                    break;
                case "POVERALL":
                    System.out.println(d.pOverall());
                    break;
                case "TEAM":
                	if(responseArray[1].charAt(4)=='A')
                		System.out.println(d.team(d.teamA));
                	else if(responseArray[1].charAt(4)=='B')
                		System.out.println(d.team(d.teamB));
                	else if(responseArray[1].charAt(4)=='C')
                		System.out.println(d.team(d.teamC));
                	else
                		System.out.println(d.team(d.teamD));
                    break;
                case "STARS":
                	if(responseArray[1].charAt(4)=='A')
                		System.out.println(d.stars(d.teamA));
                	else if(responseArray[1].charAt(4)=='B')
                		System.out.println(d.stars(d.teamB));
                	else if(responseArray[1].charAt(4)=='C')
                		System.out.println(d.stars(d.teamC));
                	else
                		System.out.println(d.stars(d.teamD));
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
