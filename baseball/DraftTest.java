package baseball;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DraftTest {

    Draft d;
    @Before
    public void before() {
        d = new Draft();
    }

    @Test
    public void oDraft() {
        //testing draft player
        d.oDraft("B", "Porcello, R");
        assertTrue(d.teamB.fullRoster.size() == 1);

        //testing already drafted player
        assertEquals("Player not found",d.oDraft("C" , "Porcello, R"));

        //testing invalid team name
        assertEquals("Invalid team name!", d.oDraft("invalid", "Porcello, R"));
    }

    @Test
    public void iDraft() {
        //testing draft player
        d.iDraft("Porcello, R");
        assertTrue(d.teamA.fullRoster.size() == 1);

        //testing nonexistent player
        assertEquals("Player not found",d.iDraft("Invlaid, Name"));

        //testing already drafted player
        assertEquals("Player not found",d.iDraft("Porcello, R"));
        assertTrue(d.teamA.fullRoster.size() == 1);

    }

    @Test
    public void sufficientPlayerName(){
        //test not specific enough name
        assertEquals(d.iDraft("Sanchez"),"The given name was insufficient in identifying a unique player, please enter a first initial as well");

        //test only last name but specific enough
        d.iDraft("Porcello");
        assertTrue(d.teamA.fullRoster.size() == 1);


    }
}