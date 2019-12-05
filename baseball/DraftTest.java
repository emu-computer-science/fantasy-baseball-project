package baseball;

import java.io.File;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DraftTest {
    Draft d;
    String fileName = "TestCase";

    @Before
    public void setUp() throws Exception {
        this.d = new Draft();
    }

    @Test
    public void save() {
        d.oDraft("A", "Soroka, M");
        d.oDraft("B", "Verlander, J");
        d.oDraft("C", "Rodriguez, E");
        d.oDraft("D", "Bellinger, C");
        d.save(fileName);
        File file = new File(fileName + " A.fantasy.txt");
        assertTrue(file.exists());
        file = new File(fileName + " B.fantasy.txt");
        assertTrue(file.exists());
        file = new File(fileName + " C.fantasy.txt");
        assertTrue(file.exists());
        file = new File(fileName + " D.fantasy.txt");
        assertTrue(file.exists());
    }


    @Test
    public void restore() {
        save();
        d.restore(fileName);

        assertEquals(d.teamA.fullRoster.get(0).getName(), "Soroka, M");
        assertEquals(d.teamB.fullRoster.get(0).getName(), "Verlander, J");
        assertEquals(d.teamC.fullRoster.get(0).getName(), "Rodriguez, E");
        assertEquals(d.teamD.fullRoster.get(0).getName(), "Bellinger, C");
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