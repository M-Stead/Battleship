package ca.shaw.bs.board.grid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShipSquareTest {

	private ShipSquare testShipQuare;
	
	@Before
	public void setUp() throws Exception {
		this.testShipQuare = new ShipSquare();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(GridSquareValue.WATER.name(), this.testShipQuare.getGridResult());
		assertEquals(GridSquareValue.WATER.getValue(), this.testShipQuare.getGridValue());
		assertFalse(this.testShipQuare.getSquareHit());
		
		this.testShipQuare.targetSquare();
		
		assertEquals(GridSquareValue.HIT.name(), this.testShipQuare.getGridResult());
		assertEquals(GridSquareValue.HIT.getValue(), this.testShipQuare.getGridValue());
		assertTrue(this.testShipQuare.getSquareHit());
	}

}
