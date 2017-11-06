package ca.shaw.bs.board;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


public class BoardTest {

	Board testBoard;
	@Before
	public void setUp() throws Exception {
		 testBoard = new Board();
	}

	@Test
	public void constructBoard_ValidBoardSize()
	{
		testBoard.constructBoard(8);
		
	}
	
	@Test(expected = NegativeArraySizeException.class)
	public void constructBoard_InValidBoardSize()
	{
		testBoard.constructBoard(-1);
	}

}
