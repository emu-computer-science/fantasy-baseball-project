package baseball;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.script.ScriptException;

import org.junit.*;


public class PrintTests {

	Draft d;
	@Before
	public void before() {
		d = new Draft();
	}
	
	@Test
	public void testPrintCatchers() {
		String players="Ramos, W | NYM | C | 0.288\n" + 
				"Vazquez, C | BOS | C | 0.276\n" + 
				"Realmuto, J | PHI | C | 0.275\n" + 
				"Grandal, Y | MIL | C | 0.246\n";
		assertEquals(players, d.overall("C"));
	}
	
	@Test
	//Needs throws to keep compiler happy
	public void testPrintCatchersAfterValuation() throws ScriptException {
		d.evalFun("AVG*RUNS");
		String players="Realmuto, J | PHI | C | 25.3\n" + 
				"Grandal, Y | MIL | C | 19.43\n" + 
				"Vazquez, C | BOS | C | 18.22\n" + 
				"Ramos, W | NYM | C | 14.98\n";
		assertEquals(players, d.overall("C"));
	}
	
	@Test
	public void testPrintFilledPosition() {
		d.iDraft("Ramos, W");
		assertEquals("Position filled already", d.overall("C"));
	}
	
	//Rather than entering each pitcher by hand, I am testing if the function
	//return string contains the first, middle, and last pitcher element.
	@Test
	public void testFirstPitcher() {
		String tmp = "Ryu, H | LAD | P | 182.2";
		assertTrue(d.pOverall().contains(tmp));
	}
	
	@Test
	public void testMiddlePitcher() {
		String tmp = "Nola, A | PHI | P | 202.1";
		assertTrue(d.pOverall().contains(tmp));
	}
	
	@Test
	public void testLastPitcher() {
		String tmp = "Porcello, R | BOS | P | 174.1";
		assertTrue(d.pOverall().contains(tmp));
	}
	
	@Test
	public void testPitchersAfterValuation() throws ScriptException {
		String tmp = "Porcello, R | BOS | P | 242.0";
		d.pEvalFun("IP*WHIP");
		assertTrue(d.pOverall().contains(tmp));
	}
	
	@Test
	public void testOneStar() {
		String player = "C Ramos, W \n";
		d.iDraft("Ramos, W");
		assertEquals(player, d.stars("A"));
	}
	
	@Test
	public void testThreeStars() {
		d.iDraft("Odor, R");
		d.iDraft("Gurriel, Y");
		String threePlayers= "2B Odor, R \n"+
		"1B Gurriel, Y \n";
		assertEquals(threePlayers, d.stars("A"));
	}
	
}
