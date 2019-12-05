package baseball;

import java.io.File;

import static org.junit.Assert.*;

public class DraftTest {
    Draft d;
    String fileName = "TestCase";

    @org.junit.Before
    public void setUp() throws Exception {
        this.d = new Draft();

        d.oDraft("A", "Soroka, M");
        d.oDraft("B", "Verlander, J");
        d.oDraft("C", "Rodriguez, E");
        d.oDraft("D", "Bellinger, C");
    }

    @org.junit.Test
    public void save() {
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


    @org.junit.Test
    public void restore() {
        d.save(fileName);
        d.restore(fileName);

        assertEquals(d.teamA.fullRoster.get(0).getName(), "Soroka, M");
        assertEquals(d.teamB.fullRoster.get(0).getName(), "Verlander, J");
        assertEquals(d.teamC.fullRoster.get(0).getName(), "Rodriguez, E");
        assertEquals(d.teamD.fullRoster.get(0).getName(), "Bellinger, C");
    }
}