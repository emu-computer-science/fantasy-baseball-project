package baseball;

import java.util.Scanner;

import javax.script.ScriptException;

public class Driver {

	public static void main(String[] args) {
		// Use this scanner to read the user input!
		Scanner keyboard = new Scanner(System.in);

		Draft d = new Draft();

		String response;

		do {
			System.out.println("Select an option:\n" + "ODRAFT lastName, firstInitial leagueMember\n"
					+ "IDRAFT  lastName, firstInitial\n" + "OVERALL  POSITION OR LEAVE BLANK FOR ALL POSITIONS\n"
					+ "POVERALL \n" + "TEAM teamName \n" + "STARS teamName \n" + "SAVE fileName \n"
					+ "RESTORE fileName \n" + "EVALFUN Expression with hitter stats \n"
					+ "PEVALFUN Expression with pitcher stats \n" + "QUIT");

			response = keyboard.nextLine();
			String[] responseArray = response.split(" ");

			try {
				switch (responseArray[0].toUpperCase()) {
				case "ODRAFT":
					if (responseArray[1].indexOf('"') != responseArray[1].lastIndexOf('"'))
						System.out.println(d.oDraft(responseArray[2].toUpperCase(), responseArray[1].toUpperCase()));
					else if ((responseArray[1].indexOf('"') >= 0) && (responseArray[2].indexOf('"') > 0))
						System.out.println(d.oDraft(responseArray[3].toUpperCase(),
								responseArray[1].toUpperCase() + " " + responseArray[2].toUpperCase()));
					else
						System.out.println("Please provide team name, followed by player name in qoutation marks");
					break;
				case "IDRAFT":
					if (responseArray[1].indexOf('"') != responseArray[1].lastIndexOf('"'))
						System.out.println(d.iDraft(responseArray[1].toUpperCase()));
					else if ((responseArray[1].indexOf('"') >= 0) && (responseArray[2].indexOf('"') > 0))
						System.out.println(
								d.iDraft(responseArray[1].toUpperCase() + " " + responseArray[2].toUpperCase()));
					else
						System.out.println("Please provide Player name in qoutation marks");
					break;
				case "OVERALL":
					if (responseArray.length > 1) {
						System.out.println(d.overall(responseArray[1].toUpperCase()));
					} else if (responseArray.length == 1) {
						System.out.println(d.overall(""));
					}
					break;
				case "POVERALL":
					System.out.println(d.pOverall());
					break;
				case "TEAM":
					d.team(responseArray[1].toUpperCase());
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
					String exp = "";
                	for(int i = 1; i < responseArray.length; i++)
                		exp += responseArray[i];
                	d.evalFun(exp.toUpperCase());
					break;
				case "PEVALFUN":
					String pExp = "";
                	for(int i = 1; i < responseArray.length; i++)
                		pExp += responseArray[i];
                	if(!pExp.isEmpty())
                		d.pEvalFun(pExp.toUpperCase());
					break;
				case "QUIT":
					System.exit(0);
				default:
					System.out.println("Invalid Option.");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Incorrect amount of paramaters");
			}
		} while (true);
	}
}
