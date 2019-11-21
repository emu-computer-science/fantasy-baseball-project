import static org.junit.Assert.assertEquals;
import org.junit.*;


public class PrintTests {
	
	Player playerA= null;
	Player playerB= null;
	Player playerC= null;
	Player playerD= null;
	Player playerE= null;
	Team teamA= null;
	@Before
	public void before() {
		playerA= new Player("Martinez, J","1B", "Detroit Tigers", 10, 50, 1, 0.0);
		playerB= new Player("Smith, J","C", "Detroit Tigers", 10, 50, 1, 0.0);
		playerC= new Player("Wayne, B","C", "Detroit Tigers", 10, 50, 1, 0.0);
		playerD= new Player("Simpson, H","C", "Detroit Tigers", 10, 50, 1, 0.0);
		playerE= new Player("Ray, B","P1", "Detroit Tigers", 10, 50, 1, 0.0);
		teamA = new Team("Rockets");
	}
	
	@Test
	public void testPrintOnePlayer() {
		assertEquals(playerA.toString()+"\n", Draft.overall("1B"));
	}
	@Test
	public void testPrintThreePlayer() {
		String printThree = playerB.toString()+"\n"+playerC.toString()+"\n"+playerD.toString()+"\n";
		assertEquals(printThree, Draft.overall("C"));
	}
	
	@Test
	public void testPrintFilledPosition() {
		assertEquals("That position is filled", Draft.overall("2B"));
	}
	
	@Test
	public void testPrintPitchers() {
		assertEquals(playerE.toString()+"\n", Draft.pOverall());
	}
	
	@Test
	public void testOnePlayerTeam() {
		teamA.draftPlayer(playerA);
		assertEquals(playerA.toString()+"\n", Draft.team(teamA));
	}
	
	@Test
	public void testThreePlayerTeam() {
		teamA.draftPlayer(playerA);
		teamA.draftPlayer(playerB);
		teamA.draftPlayer(playerE);
		String threePlayers= playerB.toString()+"\n"+playerA.toString()+"\n"+playerE.toString()+"\n";
		assertEquals(threePlayers, Draft.team(teamA));
	}
	
}
