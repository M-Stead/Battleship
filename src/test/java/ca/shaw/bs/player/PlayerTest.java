package ca.shaw.bs.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	Player player;
	
	@Before
	public void setUp() throws Exception {
		 player = new Player("Test");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validAlignmentType_ValidAlignmentType() {
		assertTrue(player.validAlignmentType("H"));
		assertTrue(player.validAlignmentType("V"));
	}

	@Test
	public void validAlignmentType_InValidAlignmentType() {
		assertFalse(player.validAlignmentType("D"));
		assertFalse(player.validAlignmentType("U"));
	}
	
	@Test
	public void isDead_Decrement()
	{
		for(int i=0 ;i <3;i++)
			player.opponentHit();
		
		assertTrue(player.isDead());
	}

	
}
