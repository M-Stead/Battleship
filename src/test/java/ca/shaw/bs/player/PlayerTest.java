package ca.shaw.bs.player;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;



public class PlayerTest {

	Player testPlayer;
	
	@Before
	public void setUp() throws Exception {
		 testPlayer = new Player("Test");
				
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void validAlignmentType_ValidAlignmentType() {
		assertTrue(testPlayer.validAlignmentType("H"));
		assertTrue(testPlayer.validAlignmentType("V"));
	}

	@Test
	public void validAlignmentType_InValidAlignmentType() {
		assertFalse(testPlayer.validAlignmentType("D"));
		assertFalse(testPlayer.validAlignmentType("U"));
	}
	
	@Test
	public void isDead_Decrement()
	{
		for(int i=0 ;i <3;i++)
			testPlayer.opponentHit();
		
		assertTrue(testPlayer.isDead());
	}
	
}
