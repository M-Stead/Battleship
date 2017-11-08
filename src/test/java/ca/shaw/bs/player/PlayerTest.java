package ca.shaw.bs.player;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ca.shaw.bs.board.Board;
import ca.shaw.bs.board.grid.GridSquareValue;

public class PlayerTest {

	Player testPlayer;
	@Mock
	Player mockPlayer;
	
	@Before
	public void setUp() throws Exception {
		 testPlayer = new Player("Test");
		 mockPlayer = Mockito.mock(Player.class);
				
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
