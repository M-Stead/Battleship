package ca.shaw.bs.board;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ca.shaw.bs.board.grid.GridSquareValue;
import ca.shaw.bs.board.grid.IGridSquare;
import ca.shaw.bs.board.grid.ShipSquare;
import ca.shaw.bs.board.grid.WaterSquare;
import ca.shaw.bs.board.grid.WaterSquareTest;


public class BoardTest {

	Board testBoard;

	
	@Before
	public void setUp() throws Exception {
		 testBoard = new Board();
	}
	
	@After
	public void teardown() throws Exception {
		 testBoard = null;
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
		assertEquals(true,testBoard.validatePlacementCoordinates("H",1,1));
	}
	
	@Test
	public void validateCoordinates_OutOfRange_Horizontal_Placement()
	{
		assertEquals(false,testBoard.validatePlacementCoordinates("H",6,1));
	}
	
	@Test
	public void validateCoordinates_OutOfRange_Vertical_Placement()
	{
		assertEquals(false,testBoard.validatePlacementCoordinates("V",1,6));
	}
	
	@Test
	public void validateCoordinates_InRange_Vertical_Placement()
	{
		assertEquals(true,testBoard.validatePlacementCoordinates("V",1,4));
	}
	
	@Test
	public void placeShipsOnBoard_InRange_Vertical_Placement()
	{
		testBoard.placeShipsOnBoard("V", "A", "2");
		IGridSquare[][] board = testBoard.getBoard();
		assertThat (board[1][0], instanceOf(ShipSquare.class));
		assertThat (board[2][0], instanceOf(ShipSquare.class));
		assertThat (board[3][0], instanceOf(ShipSquare.class));
		assertThat (board[0][5], instanceOf(WaterSquare.class));
		assertThat (board[1][4], instanceOf(WaterSquare.class));
	}
	
	@Test
	public void placeShipsOnBoard_InRange_Horizontal_Placement()
	{
		testBoard.placeShipsOnBoard("H", "A", "2");
		IGridSquare[][] board = testBoard.getBoard();
		assertThat (board[1][0], instanceOf(ShipSquare.class));
		assertThat (board[1][1], instanceOf(ShipSquare.class));
		assertThat (board[1][2], instanceOf(ShipSquare.class));
		assertThat (board[0][5], instanceOf(WaterSquare.class));
		assertThat (board[1][4], instanceOf(WaterSquare.class));
	}
	
	@Test
	public void placeShipsOnBoard_OutOfRange_Vertical_Placement() throws UnsupportedEncodingException
	{
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent, true, "UTF8"));
		
	    testBoard.placeShipsOnBoard("V", "H", "7");
	    
	    String expectedOutput  = "Invalid Coordinates passed in for ship placement. Ship not placed\n"; 
	    assertEquals(expectedOutput, outContent.toString("UTF8"));
	  
	}
	
	@Test
	public void placeShipsOnBoard_OutOfRange_Horizontal_Placement() throws UnsupportedEncodingException
	{
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent, true, "UTF8"));
		
	    testBoard.placeShipsOnBoard("H", "H", "7");
	    
	    String expectedOutput  = "Invalid Coordinates passed in for ship placement. Ship not placed\n"; 
	    assertEquals(expectedOutput, outContent.toString("UTF8"));
	}
	
	@Test
	public void validateShootingCoordinate_ValidCoordinate()
	{
		assertTrue (this.testBoard.validateShootingCoordinate(0,0));
	}

	@Test
	public void validateShootingCoordinate_inValidCoordinate()
	{
		assertFalse (this.testBoard.validateShootingCoordinate(-1,0));
	}
	
	
	@Test
	public void shootAtBoard_invalidShot()
	{
		Board spyBoard = Mockito.spy(testBoard);
		when((spyBoard).validateShootingCoordinate(0, 1)).thenReturn(false);
		
		assertEquals (GridSquareValue.INVALID.name(), spyBoard.shootAtBoard("B", "1"));
	}
	
	@Test
	public void shootAtBoard_validShot()
	{
		Board spyBoard = Mockito.spy(testBoard);
		when((spyBoard).validateShootingCoordinate(0, 1)).thenReturn(true);
		assertEquals (GridSquareValue.MISS.name(), spyBoard.shootAtBoard("B", "1"));
		
	}
}
