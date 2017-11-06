package ca.shaw.bs.board;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
		assertEquals(testBoard.getBoard().length, 8);	
	}
	
	@Test(expected = NegativeArraySizeException.class)
	public void constructBoard_InValidBoardSize()
	{
		testBoard.constructBoard(-1);
		assertEquals(testBoard.getBoard().length, 0);
		fail("Expected an NegativeArraySizeException");
	}
	
	@Test
	public void validateCoordinates_InRange_Horizontal_Placement()
	{
		assertEquals(true,testBoard.validateCoordinates("H",1,1));
	}
	
	@Test
	public void validateCoordinates_OutOfRange_Horizontal_Placement()
	{
		assertEquals(false,testBoard.validateCoordinates("H",6,1));
	}
	
	@Test
	public void validateCoordinates_OutOfRange_Vertical_Placement()
	{
		assertEquals(false,testBoard.validateCoordinates("V",1,6));
	}
	
	@Test
	public void validateCoordinates_InRange_Vertical_Placement()
	{
		assertEquals(true,testBoard.validateCoordinates("V",1,4));
	}
	
	@Test
	public void placeShipsOnBoard_InRange_Vertical_Placement()
	{
		testBoard.placeShipsOnBoard("V", "A", "2");
		IGridSquare[][] board = testBoard.getBoard();
		assertThat (board[0][2], instanceOf(ShipSquare.class));
		assertThat (board[1][2], instanceOf(ShipSquare.class));
		assertThat (board[2][2], instanceOf(ShipSquare.class));
		assertThat (board[0][5], instanceOf(WaterSquare.class));
		assertThat (board[1][4], instanceOf(WaterSquare.class));
	}
	
	@Test
	public void placeShipsOnBoard_InRange_Horizontal_Placement()
	{
		testBoard.placeShipsOnBoard("H", "A", "2");
		IGridSquare[][] board = testBoard.getBoard();
		assertThat (board[0][2], instanceOf(ShipSquare.class));
		assertThat (board[0][3], instanceOf(ShipSquare.class));
		assertThat (board[0][4], instanceOf(ShipSquare.class));
		assertThat (board[0][5], instanceOf(WaterSquare.class));
		assertThat (board[1][4], instanceOf(WaterSquare.class));
	}
	
	@Test
	public void placeShipsOnBoard_OutOfRange_Vertical_Placement()
	{
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		
	    testBoard.placeShipsOnBoard("V", "H", "7");
	    
	    String expectedOutput  = "Invalid Coordinates passed in for ship placement. Ship not placed\n"; 
	    assertEquals(expectedOutput, outContent.toString());
	  
	}
	
	@Test
	public void placeShipsOnBoard_OutOfRange_Horizontal_Placement()
	{
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		
	    testBoard.placeShipsOnBoard("H", "H", "7");
	    
	    String expectedOutput  = "Invalid Coordinates passed in for ship placement. Ship not placed\n"; 
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	public void pStuff()
	{
		//testBoard.placeShipsOnBoard("V", "G", "4");
		//testBoard.printBoard();
	}
	
}
