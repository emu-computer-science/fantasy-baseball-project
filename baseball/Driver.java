package baseball;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.script.ScriptException;

public class Driver {

    public static void main(String[] args) throws ScriptException {
        // Use this scanner to read the user input!
        Scanner keyboard = new Scanner(System.in);

        Draft d = new Draft();

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

            try {
            switch (responseArray[0].toUpperCase()) {
                // TODO: make sure each command has a case!
                case "ODRAFT":
                        System.out.println(d.oDraft(responseArray[2].toUpperCase(), responseArray[1].toUpperCase()));
                    break;
                case "IDRAFT":
                        System.out.println(d.iDraft(responseArray[1].toUpperCase()));
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
                        d.printRoster(responseArray[1].toUpperCase());
                    break;
                case "STARS":
                    System.out.println(d.stars(responseArray[1].toUpperCase()));
                    break;
                case "SAVE":
                    d.save(responseArray[1]);
                    break;
                case "RESTORE":
                    d.restore(responseArray[1]);
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
            }catch(ArrayIndexOutOfBoundsException e) {
            	System.out.println("Incorrect amount of paramaters");
            }
        } while (true);
    }
}
